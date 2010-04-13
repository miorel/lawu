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
package com.googlecode.lawu.net.www.spoj;

public enum Language {
	ADA("Ada"),
	ASSEMBLY("ASM", "assembly language"),
	BASH("BAS", "bash"),

	/**
	 * Constant for brainfuck, an esoteric, minimalist programming language.
	 */
	BRAINFUCK("BF", "brainfuck"),
	C,
	C_SHARP("C#", "C#"),
	C_PLUS_PLUS("C++", "C++"),
	
	/**
	 * Constant for the C99 dialect of the C programming language.
	 */
	C99,
	OCAML("CAM", "OCaml"),
	CLIPS("CLP", "Clips"),
	D,
	ERLANG("ERL", "Erlang"),
	FORTRAN("FOR", "Fortran"),
	HASKELL("HAS", "Haskell"),
	INTERCAL("ICK", "Intercal"),
	ICON("ICO", "Icon"),
	JAR("jar format"),
	JAVA("JAV", "Java"),
	JAVASCRIPT("JS", "JavaScript"),
	LISP("LIS", "Common Lisp"),
	LUA("Lua"),
	NEMERLE("NEM", "Nemerle"),
	NICE("NIC", "Nice"),
	PASCAL("PAS", "Pascal"),

	/**
	 * Constant for Larry Wall's Practical Extraction and Report Language
	 * (Perl).
	 */
	PERL("PER", "Perl"),
	PHP,
	PIKE("PIK", "Pike"),
	PROLOG("PRL", "Prolog"), 
	PYTHON("PYT", "Python"),
	RUBY("RUB", "Ruby"),
	SCALA("SCA", "Scala"),
	SCHEME("SCM", "Scheme"),

	/**
	 * Constant for Smalltalk, a dynamically typed object-oriented language.
	 */
	SMALLTALK("ST", "Smalltalk"),
	TCL("Tcl"),
//	TECS("TECS"),
	PLAIN_TEXT("TEX", "plain text"),
	WHITESPACE("WSP", "Whitespace");
	
	private final String spojName;
	private final String realName;	

	private Language() {
		this.spojName = toString();
		this.realName = toString();
	}
	
	private Language(String realName) {
		this.spojName = toString();
		this.realName = realName;
	}
	
	private Language(String spojName, String realName) {
		this.spojName = spojName;
		this.realName = realName;
	}
	
	public String getRealName() {
		return this.realName;
	}

	public String getSpojName() {
		return this.spojName;
	}
	
	public static Language forSpojName(String spojName) {
		Language ret = null;
		for(Language lang: Language.values())
			if(lang.spojName.equals(spojName)) {
				ret = lang;
				break;
			}
		return ret;
	}
}
