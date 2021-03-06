#!/usr/bin/perl
#
# script to generate code from the specification for the PDB format
# 

use warnings;
use strict;

use LWP::Simple;
use Switch;

### BEGIN CONFIG ###############################################################
my $in_file = 'util/data/pdb_spec.out';
my $package = 'lawu.chem.pdb.records';
my $out_dir = "src/$package"; $out_dir =~ s/\./\//g;
### END CONFIG #################################################################

my($fh, $spec);
open $fh, "<$in_file" or die "Failed to open $in_file for reading";
{
	local $/;
	$spec = <$fh>;
}
close $fh;

local %_ = ();
for($spec =~ /<pre>\s*(COLUMNS\s+DATA TYPE\s+FIELD\s+DEFINITION.*?)<\/pre>/sig) {
	local @_ = split /\n/;
	my($record_name) = ($_[2] =~ /Record name\s+\"([A-Z]+)/);
	$_{$record_name} = \@_ unless $_{$record_name};
}

while(my($record_name, $val) = each %_) {
	next if $record_name =~ /^(?:author|compnd|expdta|header|hetsyn|keywds|master|remark|revdat|source|ssbond)$/i;
	print "Writing parser for $record_name records\n";
	local @_ = @$val;
	$_[0] =~ /^(COLUMNS\s+)(DATA TYPE\s+)(FIELD\s+)DEFINITION/;
	my $columns_length = length($1);
	my $data_type_length = length($2);
	my $field_length = length($3);
	my @fields = ();
	my $pattern = $record_name;
	my $format = $record_name;
	my $pattern_length = length($pattern);
	if($_[2] =~ /\"[A-Z]+[n\d]\s*\"/) {
		$pattern .= "(\\\\d)";
		$format .= "%d";
		++$pattern_length;
		push @fields, ['int', 'n', ''];
	}
	if($pattern_length < 6) {
		my $append = ' ' x (6 - $pattern_length); 
		$pattern .= $append;
		$format .= $append;
		$pattern_length = 6;
	}
	$record_name =~ /^(.)(.*)/;
	my $class_name = $1 . lc($2);
	for(@_[3..$#_]) {
		my($columns, $data_type, $field, $definition) = /^([\d\- ]{0,$columns_length})(.{0,$data_type_length})(\S{0,$field_length})(.*)/;
		$field = "$2$field" if $data_type =~ s/(\S\s{2,})(\S.*)$/$1/;
		if($columns !~ /^\s+$/) {
			my($start, $end) = $columns =~ /(\d+)\s*\-?\s*(\d*)/;
			$end = $start unless length($end);
			if($pattern_length != $start - 1) {
				my $append = ' ' x ($start - 1 - $pattern_length);
				$pattern .= $append;
				$format .= $append;
			}
			$pattern .= sprintf("(%s)", '.' x ($end - $start + 1));
			$format .= sprintf("%%%ds", $end - $start + 1);
			$pattern_length = $end;
			$field =~ s/[\[\]]//g;
			push @fields, [$data_type, $field, $definition];
		}
		else {
			$fields[-1]->[2] .= " $definition";
			$fields[-1]->[0] .= " $data_type";
			$fields[-1]->[0] =~ s/\s+/ /g;
		}
	}
	if($pattern_length < 80) {
		my $append = ' ' x (80 - $pattern_length);
		$pattern .= $append;
		$format .= $append;
		$pattern_length = 80;
	}
	$pattern =~ s/(([ \.])(\2*))/
		my $alt = sprintf("%s{%d}", $2, length($1));
		length($alt) <= length($1) ? $alt : $1
	/eg for ' .' =~ /./g;
	for(@fields) {
		$_->[2] =~ s/\s+/ /g;
		s/\s+$//g for @$_;
		$_->[0] = 'AtomName' if $_->[0] =~ /^atom$/i;
		$_->[0] = 'SymOp' if $_->[0] =~ /^symop$/i;
		$_->[0] = 'IdCode' if $_->[0] =~ /^idcode$/i;
		$_->[0] = 'ResidueName' if $_->[0] =~ /^residue name$/i;
		$_->[0] = 'SpecificationList' if $_->[0] =~ /^specification list$/i;
		$_->[0] =~ s/^((?:Character|Integer|String|List)\(?\d*\)?)$/lawu.chem.pdb.primitives.$1/;
	}
	my $out_file = sprintf("%s/%s.java", $out_dir, $class_name);
	open $fh, ">$out_file" or die "Failed to open $out_file for writing";
	print $fh <<"EOF";
package $package;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lawu.chem.pdb.primitives.AChar;
import lawu.chem.pdb.primitives.AtomName;
import lawu.chem.pdb.primitives.Continuation;
import lawu.chem.pdb.primitives.Date;
import lawu.chem.pdb.primitives.IdCode;
import lawu.chem.pdb.primitives.LString;
import lawu.chem.pdb.primitives.Real;
import lawu.chem.pdb.primitives.ResidueName;
import lawu.chem.pdb.primitives.SymOp;

/**
 * \@author Miorel-Lucian Palii
 */
public class $class_name {
EOF
	my %fields;
	%fields = (); ++$fields{$_->[1]} for @fields;
	for(@fields) {
		$_->[0] =~ /^([a-z\. ]+)/i;
		my $count = $fields{$_->[1]};
		next unless $count;
		if($count == 1) {
			print $fh "\tprivate $1 $_->[1];\n";
		}
		else {
			print $fh "\tprivate List<$1> $_->[1]List = new ArrayList<$1>($count);\n";
		}
		$fields{$_->[1]} = 0;
	}
	print $fh <<"EOF";

	private final static Pattern pattern = Pattern.compile("$pattern"); //\$NON-NLS-1\$
	private final static String format = "$format"; //\$NON-NLS-1\$

	public $class_name(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
EOF
	%fields = (); ++$fields{$_->[1]} for @fields;
	for my$i(1..scalar(@fields)) {
		local $_ = $fields[$i-1];
		my $count = $fields{$_->[1]};
		my @args = ("m.group($i)");
		my $build = undef;
		switch($_->[0]) {
			case 'int' {
				$build = 'Integer.parseInt';
			}
			case m/(?:\.|^)(?:AChar|Character|Date|Integer|String|Continuation|LString|AtomName|SymOp|IdCode)$/i {
				$build = "new $_->[0]";
			}
			case m/^Real\(\d+\.\d+\)$/ {
				$build = "new Real";
				$_->[0] =~ /\((\d+)\.(\d+)\)$/;
				push @args, ($1, $2);
			}
			case m/^LString\(\d+\)$/ {
				$build = "new LString";
				$_->[0] =~ /(\d+)\)$/;
				push @args, $1;
			}
		}
		$build ||= "new $_->[0]";
		if($count == 1) {
			printf($fh "\t\tthis.%s = %s(%s);\n", $_->[1], $build, join(", ", @args));
		}
		else {
			printf($fh "\t\tthis.%sList.add(%s(%s));\n", $_->[1], $build, join(", ", @args));
		}
	}
	print $fh <<"EOF";
	}

EOF
	for(grep {$_->[2]} @fields) {
		print $fh "\t/**\n\t * $_->[2]\n\t */\n";
		print $fh "//\tpublic $_->[0] $_->[1]() {\n";
		print $fh "//\t\treturn $_->[1];\n";
		print $fh "//\t}\n\n";
	}
	print $fh <<"EOF";
	\@Override	
	public String toString() {
		return String.format(format);
	}

	\@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof $class_name) {
			$class_name r = ($class_name) o;
			
		}
		return ret;
	}

	\@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
EOF
	close $fh;
}


