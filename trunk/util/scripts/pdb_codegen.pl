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
	$_{$record_name} ||= [];
	$_{$record_name} = [@{$_{$record_name}}, @_, ''];
}

while(my($record_name, $val) = each %_) {
	local @_ = @$val;
	pop @_;
	$record_name =~ /^(.)(.*)/;
	my $class_name = $1 . lc($2);
	my $out_file = sprintf("%s/%s.java", $out_dir, $class_name);
	print "Writing parser for $record_name records\n";
	open $fh, ">$out_file" or die "Failed to open $out_file for writing";
	print $fh <<"EOF";
package $package;

public class $class_name {
EOF
	for(@_) {
		print $fh "// $_\n";
	}
	print $fh <<"EOF";
	public $class_name() {
	}

	\@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
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

