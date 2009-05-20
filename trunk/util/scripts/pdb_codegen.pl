#!/usr/bin/perl
#
# script to generate code from the specification for the PDB format
# 

use warnings;
use strict;

use LWP::Simple;

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
		my($columns, $data_type, $field, $definition) = /^(.{0,$columns_length})(.{0,$data_type_length})(.{$field_length})(.*)/;
		if($columns !~ /^\s+$/) {
			push @fields, [$data_type, $field, $definition];
		}
		else {
			$fields[-1]->[2] .= " $definition";
		}
	}
	for(@fields) {
		$_->[2] =~ s/\s+/ /g;
		s/\s+$//g for @$_;
	}
	my $out_file = sprintf("%s/%s.java", $out_dir, $class_name);
	open $fh, ">$out_file" or die "Failed to open $out_file for writing";
	print $fh <<"EOF";
package $package;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class $class_name {
EOF
	for(@fields) {
		print $fh "//\tprivate $_->[0] $_->[1];\n";
	}
	print $fh <<"EOF";

	private final static Pattern pattern = Pattern.compile("\\\\A$pattern\\\\Z"); //\$NON-NLS-1\$
	private final static String format = "$format"; //\$NON-NLS-1\$

	public $class_name(String record) {
		Matcher m = pattern.matcher(record);
		if(!m.matches())
			throw new RuntimeException();
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
