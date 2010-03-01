#!/usr/bin/perl

use warnings;
use strict;

use File::Find;
use File::Path;
use File::Spec;

# strip the file portion from the script name and change directory
my $dir = File::Spec->catpath((File::Spec->splitpath($0))[0..1]);
chdir $dir;

my $generated_source_dir = shift;

find({wanted => sub {
	return unless -f && /\.java\.pl$/;

	my @file = File::Spec->splitdir(File::Spec->abs2rel($File::Find::name));
	my $script = File::Spec->catfile(@file);
	$file[-1] =~ s/\.pl$//;
	my $out_file = File::Spec->catfile($generated_source_dir, @file);

	pop @file;
	my $out_package = join(".", @file);

	create_parent_dir($out_file);
	
	print "Generating $out_file\n";
	{
		local *STDOUT;
		open STDOUT, ">$out_file" or die "Couldn't open $out_file for writing";
		print "package $out_package;\n\n";
		do $script or die "Generator failed";
		close STDOUT;
	};
}, no_chdir => 1}, '.');

sub create_parent_dir {
	my @outdir = File::Spec->splitdir(shift);
	pop @outdir;
	my $outdir = File::Spec->catdir(@outdir);
	return File::Path::make_path($outdir) or die "Couldn't create directory: $outdir";
}
