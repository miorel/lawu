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
package lawu.chem.pdb.primitives;

import lawu.chem.Element;

/**
 * @author Miorel-Lucian Palii
 */
public class AtomName {
	private Element element;
	private char remotenessIndicator;
	private char branchDesignator;
	
	public AtomName() {
		this(" CA "); //$NON-NLS-1$
	}
	
	public AtomName(java.lang.String atomName) {
		setAtomName(atomName);
	}
	
	public Element getElement() {
		return this.element;
	}
	
	public char getRemotenessIndicator() {
		return this.remotenessIndicator;
	}
	
	public char getBranchDesignator() {
		return this.branchDesignator;
	}
	
	protected void setAtomName(java.lang.String atomName) {
		if(atomName == null)
			throw new NullPointerException("");
		if(!atomName.matches("[A-Z ][A-Z]{2}[\\d ]")) //$NON-NLS-1$
			throw new RuntimeException();
		this.element = Element.forSymbol(atomName.substring(0, 2));
		this.remotenessIndicator = atomName.charAt(2);
		this.branchDesignator = atomName.charAt(3);
	}
	
	@Override
	public java.lang.String toString() {
		return java.lang.String.format("%2s%c%c", this.element.getSymbol(),  //$NON-NLS-1$
				java.lang.Character.valueOf(this.remotenessIndicator),
				java.lang.Character.valueOf(this.branchDesignator));
	}
	
	@Override
	public int hashCode() {
		return this.element.hashCode() + (this.remotenessIndicator << 8)
			+ (this.branchDesignator << 16);
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof AtomName) {
			AtomName a = (AtomName) o;
			ret = this.element.equals(a.element)
				&& this.remotenessIndicator == a.remotenessIndicator
				&& this.branchDesignator == a.branchDesignator;
		}
		return ret;
	}
}
