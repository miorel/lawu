#!/usr/bin/perl

use warnings;
use strict;

use Data::Dumper;

my %symbol = ();
my @rule = ();

while(<DATA>) {
	next unless	$_ = trim($_); 
	my($symbol, $rule) = split(/\s*=\s*/, $_, 2);
	my @symbol = grep {$_} split(/\s+/, $rule);
	$symbol{$_} ||= [] for $symbol, @symbol;
	push @{$symbol{$symbol}}, \@symbol;
	push @rule, \@symbol;
}

while(<>) {
	my @state = ([]);
	my @token = split(/\s+/, trim($_));
	my $error = undef;
	for(@token) {
		if(!defined $symbol{$_}) {
			$error = "Unknown token: $_\n";
			last;
		}
		elsif(@{$symbol{$_}}) {
			$error = "Encountered non-terminal symbol: $_\n";
			last;
		}
	}
	unless($error) {
		for my $token (@token) {
			my @new_state = ();
			for my $state (@state) {
				printf("State [%s] encountering token %s\n", join(", ", @$state), $token);
				for my $rule (@rule) {
					consider_rule([@$state, $token], $rule);
				}
			}
			@state = @new_state;
		}
	}
	else {
		print $error;
	}
}

sub min {
	return $_[0] < $_[1] ? $_[0] : $_[1];
}

sub consider_rule {
	my($state, $rule, $symbol) = @_;
	printf("Considering rule [%s]\n", join(", ", @$rule));
	my $match_length = 0;
	for(my $i = min(scalar @$rule, scalar @$state); $i >= 1; --$i) {
		if(equals([@$rule[0..$i-1]], [@$state[-$i..-1]])) {
			$match_length = $i;
			last;
		}
	}
	print "Match length is $match_length\n";
	if($match_length == @$rule) {
		print "Rule completed!\n";
	}
	else {
		print "Shift action...\n";
		return $state;
	}
}

sub equals {
	my($a, $b) = @_;
	printf("Called with [%s] and [%s]\n", join(", ", @$a), join(", ", @$b));
	return 0 unless @$a == @$b;
	for(0..$#$a) {
		return 0 unless $a->[$_] eq $b->[$_];
	}
	return 1;
}

sub trim {
	$_[0] =~ /^\s*(.*?)\s*$/;
	return $1;
}

__DATA__

S = A B
S = A S B
