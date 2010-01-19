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
package lawu.math;

/**
 * @author Miorel-Lucian Palii
 */
public class Matrix {
	private final double[][] matrix;	
	
	public Matrix(int rows, int columns) {
		this.matrix = new double[rows][columns];
	}
	
	public int getRowCount() {
		return this.matrix.length;
	}
	
	public int getColumnCount() {
		return getRowCount() == 0 ? 0 : this.matrix[0].length;
	}
	
	public double get(int row, int column) {
		if(row < 0 || row >= getRowCount() || column < 0
				|| column >= getColumnCount())
			throw new IndexOutOfBoundsException("index out of bounds in matrix");
		return this.matrix[row][column];
	}
}
