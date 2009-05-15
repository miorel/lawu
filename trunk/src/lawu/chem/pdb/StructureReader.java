/*
 * lawu
 * Copyright (C) 2009 Miorel-Lucian Palii
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
package lawu.chem.pdb;

import static lawu.util.iterator.Iterators.filter;
import static lawu.util.iterator.Iterators.iterator;
import static lawu.util.iterator.Iterators.map;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lawu.chem.Atom;
import lawu.chem.Element;
import lawu.chem.Structure;
import lawu.dp.Iterator;
import lawu.math.Vector;
import lawu.util.Filter;
import lawu.util.Mapper;

/**
 * @author Miorel-Lucian Palii
 */
public class StructureReader {
	private final Iterator<String> iterator;
	
	public StructureReader(InputStream stream) {
		this(iterator(stream));
	}
	
	public StructureReader(Iterator<String> iterator) {
		this.iterator = iterator;
	}
	
	public Structure read() {
		Filter<String> filter = new Filter<String>() {
			@Override
			public boolean keep(String element) {
				boolean ret = false;
				if(element != null && element.length() > 6) {
					String prefix = element.substring(0, 6);
					ret = prefix.equals("HETATM") || prefix.equals("ATOM  "); //$NON-NLS-1$ //$NON-NLS-2$
				}
				return ret;
			}
		};
		Mapper<String, Atom> mapper = new Mapper<String, Atom>() {
			@Override
			public Atom map(String element) {
				Pattern pat = Pattern.compile("\\A.{30}(.{8})(.{8})(.{8})(.{6}).{16}(.{2}).{2}\\Z");
				Matcher m = pat.matcher(element);
				if(!m.matches())
					throw new RuntimeException("");
				double x = Double.parseDouble(m.group(1).trim());
				double y = Double.parseDouble(m.group(2).trim());
				double z = Double.parseDouble(m.group(3).trim());
				double occ = Double.parseDouble(m.group(4).trim());
				String symbol = m.group(5).trim();
				return new Atom(Element.forSymbol(symbol), new Vector(x, y, z), occ);
			}
		};
		return new Structure(map(mapper, filter(filter, this.iterator)));
	}
}
