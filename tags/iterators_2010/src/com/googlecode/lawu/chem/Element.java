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
package com.googlecode.lawu.chem;

import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.googlecode.lawu.util.Strings;

public final class Element {
	private final static ResourceBundle PERIODIC_TABLE = ResourceBundle.getBundle(Element.class.getPackage().getName() + ".ElementInfo");
	private final static HashMap<String, Element> bySymbol = new HashMap<String, Element>();
	
	private final String symbol;
	private final String name;
	private final int atomicNumber;
	private final double atomicRadius;
	private final double covalentRadius;
	
	private Element(String symbol, String name, int atomicNumber, double atomicRadius, double covalentRadius) {
		this.symbol = symbol;
		this.name = name;
		this.atomicNumber = atomicNumber;
		this.atomicRadius = atomicRadius;
		this.covalentRadius = covalentRadius;
	}
	
	public static Element forSymbol(String symbol) {
		String sym = Strings.toTitleCase(symbol);
		Element ret = null;
		synchronized(bySymbol) {
			ret = bySymbol.get(sym); 
			if(ret == null) {
				try {
					String[] arr = PERIODIC_TABLE.getString(sym).split(",");
					ret = new Element(sym, arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]));
				}
				catch(MissingResourceException e) {
					// it would be a lot of fun to throw a NoSuchElementException, but let's just return null for now
				}
				bySymbol.put(sym, ret);
			}
		}
		return ret;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAtomicNumber() {
		return atomicNumber;
	}

	public double getAtomicRadius() {
		return atomicRadius;
	}
	
	public double getCovalentRadius() {
		return covalentRadius;
	}
	
	@Override
	public String toString() {
		return getSymbol();
	}
	
	@Override
	public int hashCode() {
		return getAtomicNumber();
	}
}
