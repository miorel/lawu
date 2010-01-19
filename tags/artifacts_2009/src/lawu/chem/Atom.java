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
package lawu.chem;

import lawu.math.Vector;

/**
 * @author Miorel-Lucian Palii
 */
public class Atom {
	private final Element element;
	private final Vector position;
	private final double occupancy;
	
	public Atom(Element element) {
		this(element, new Vector());
	}
	
	public Atom(Element element, Vector position) {
		this(element, position, 1.0);
	}
	
	public Atom(Element element, Vector position, double occupancy) {
		this.element = element;
		this.position = position;
		this.occupancy = occupancy;
	}
	
	public Element getElement() {
		return this.element;
	}
	
	public Vector getPosition() {
		return this.position;
	}
	
	public double getOccupancy() {
		return this.occupancy;
	}
}
