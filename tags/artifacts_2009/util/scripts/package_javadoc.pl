#!/usr/bin/perl
#
# script for lazy people (like yours truly) that adds a GPLv3 notice to files
# currently only works with .java files, I may add others later
# 

use warnings;
use strict;

use File::Find;

find(sub {
	my $file = $File::Find::name;
	return unless -d && $file !~ /\.svn/;
	print "Processing $file\n";
	my $dir;
	opendir $dir, $_ or die "Failed to opendir $dir";
	local @_ = readdir $dir;
	closedir $dir;
	my $has_java = grep {/\.java$/} @_;
	my $has_package = grep {/^package\.html$/} @_;
	if($has_package && !$has_java) {
		unlink "$_/package.html";
	}
	elsif($has_java && !$has_package) {
		if(open my $fh, ">$_/package.html") {
			print $fh <<'EOF';
<html>
<head></head>
<body>Hello World!</body>
</html>
EOF
			close $fh;
		}
	}
}, '.');
