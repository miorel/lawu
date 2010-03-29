#!/usr/bin/perl
#
# script for lazy people (like yours truly) that adds a GPLv3 notice to files
# currently only works with .java files, I may add others later
# 

use warnings;
use strict;

use File::Find;

### BEGIN CONFIG ###############################################################
my $java = <<"EOF";
/*
 * Copyright (C) 2010 Miorel-Lucian Palii
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
EOF
### END CONFIG #################################################################

find(sub {
	my $file = $File::Find::name;
	return unless -f && $file !~ /\.svn/;
	print "Processing $file\n";
	if(/\.java$/i) {
		my $fh;
		open $fh, "<$_" or die "Failed to open $file for reading";
		my @in = <$fh>;
		shift @in until $in[0] =~ /^\s*(?:package|import)/;
		close $fh;
		my @out = ($java, @in);
		open $fh, ">$_" or die "Failed to open $file for writing";
		print $fh $_ for @out;
		close $fh;
	}
}, '.');
