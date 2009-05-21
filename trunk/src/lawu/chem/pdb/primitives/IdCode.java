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
public class IdCode {
	private java.lang.String idCode;
	
	public IdCode() {
		this("0000");  //$NON-NLS-1$
	}
	
	public IdCode(java.lang.String idCode) {
		setIdCode(idCode);
	}
	
	public java.lang.String getIdCode() {
		return this.idCode;
	}
	
	protected void setIdCode(java.lang.String idCode) {
		if(idCode == null)
			throw new NullPointerException("");
		if(!idCode.matches("\\d[\\dA-Z]{3}")) //$NON-NLS-1$
			throw new RuntimeException();
		this.idCode = idCode;
	}
	
	@Override
	public java.lang.String toString() {
		return getIdCode();
	}
	
	@Override
	public int hashCode() {
		int ret = 0;
		for(int i = this.idCode.length() - 1; i >= 0; --i) {
			char c = this.idCode.charAt(i);
			c -= c >= 'A' && c <= 'Z' ? 'A' - 10 : '0';
			ret = ret * (('9' - '0' + 1) + ('Z' - 'A' + 1)) + c;
		}
		return ret;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof IdCode)
			ret = this.idCode.equals(((IdCode) o).idCode);
		return ret;
	}
}
