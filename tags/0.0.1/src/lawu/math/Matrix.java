/**
 * 
 */
package lawu.math;

/**
 * @author Miorel-Lucian Palii
 *
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
