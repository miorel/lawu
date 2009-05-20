#!/usr/bin/perl
#
# script to grab specification for the PDB format
# 

use warnings;
use strict;

use LWP::Simple;

### BEGIN CONFIG ###############################################################
my $url_format = 'http://www.wwpdb.org/documentation/format23/sect%d.html';
my @range = (2..11);
my $out_file = 'util/data/pdb_spec.out';
### END CONFIG #################################################################

open my $fh, ">$out_file" or die "Failed to open $out_file for writing";

eval {
    use File::Tee qw(tee);
    tee(STDOUT, '>', $out_file);
};
if($@) {
    print STDERR "Get the File::Tee module to see script output on screen\n";
    open STDOUT, ">&", $fh;
}

print get(sprintf($url_format, $_)) for @range;

close $fh;
