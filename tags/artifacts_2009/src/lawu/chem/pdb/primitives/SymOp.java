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
public class SymOp {
	private int symmetryOperatorNumber;
	private int translationVector;
	
	public SymOp(java.lang.String symmetryOperator) {
		setSymmetryOperator(symmetryOperator);
	}
	
	public SymOp(int symmetryOperatorNumber, int translationVector) {
		setSymmetryOperatorNumber(symmetryOperatorNumber);
		setTranslationVector(translationVector);
	}
	
	protected void setSymmetryOperator(java.lang.String symmetryOperator) {
		java.lang.String symOp = symmetryOperator;
		if(symOp == null)
			throw new NullPointerException("");
		boolean valid = true;
		if(!symOp.matches(" *\\d{4,6}"))  //$NON-NLS-1$
			valid = false;
		else {
			symOp = symOp.trim();
			if(symOp.length() < 4 || symOp.length() > 6)
				valid = false;
		}
		if(!valid)
			throw new RuntimeException("");
		setSymmetryOperatorNumber(java.lang.Integer.parseInt(symOp.substring(0, symOp.length() - 3)));
		setTranslationVector(java.lang.Integer.parseInt(symOp.substring(symOp.length() - 3, symOp.length())));
	}
	
	protected void setSymmetryOperatorNumber(int symmetryOperatorNumber) {
		this.symmetryOperatorNumber = symmetryOperatorNumber;
	}
	
	protected void setTranslationVector(int translationVector) {
		this.translationVector = translationVector;
	}
	
	@Override
	public java.lang.String toString() {
		return java.lang.String.format("%3d%3d", //$NON-NLS-1$
			java.lang.Integer.valueOf(this.symmetryOperatorNumber),
			java.lang.Integer.valueOf(this.translationVector));
	}
	
	@Override
	public int hashCode() {
		return 1000 * this.symmetryOperatorNumber + this.translationVector;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof SymOp) {
			SymOp s = (SymOp) o;
			ret = this.symmetryOperatorNumber == s.symmetryOperatorNumber &&
				this.translationVector == s.translationVector;
		}
		return ret;
	}
}
