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

/**
 * @author Miorel-Lucian Palii
 */
public class ResidueName {
	private java.lang.String residueName;

	public ResidueName() {
		this("GLY"); //$NON-NLS-1$
	}

	public ResidueName(java.lang.String residueName) {
		setResidueName(residueName);
	}

	protected void setResidueName(java.lang.String residueName) {
		if(residueName == null)
			throw new NullPointerException("");
		if(!residueName.matches(" *[A-Z\\d]") && residueName.length() <= 3) //$NON-NLS-1$
			throw new RuntimeException();
		this.residueName = residueName.trim();
	}

	public java.lang.String getResidueName() {
		return this.residueName;
	}

	@Override
	public java.lang.String toString() {
		return java.lang.String.format("%3s", this.residueName); //$NON-NLS-1$
	}

	@Override
	public int hashCode() {
		return this.residueName.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof ResidueName)
			ret = this.residueName.equals(((ResidueName) o).residueName);
		return ret;
	}
}
