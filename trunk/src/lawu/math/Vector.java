package lawu.math;

/**
 * A displacement in three-dimensional space.
 * 
 * @author Miorel-Lucian Palii
 */
public class Vector {
	private final double x;
	private final double y;
	private final double z;

	/**
	 * Constructs a vector with the specified coordinates.
	 * 
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 * @param z
	 *            the z-coordinate
	 */
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Constructs a vector with the specified x- and y-coordinates and a
	 * z-coordinate of zero.
	 * 
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 */
	public Vector(double x, double y) {
		this(x, y, 0);
	}

	/**
	 * Constructs a zero vector.
	 */
	public Vector() {
		this(0, 0, 0);
	}

	/**
	 * Constructs a vector with the same coordinates as the argument.
	 * 
	 * @param vector
	 *            the coordinates
	 */
	public Vector(Vector vector) {
		this(vector.getX(), vector.getY(), vector.getZ());
	}
	
	/**
	 * Retrieves the x-coordinate of this vector.
	 * 
	 * @return the x-coordinate
	 */
	public final double getX() {
		return x;
	}

	/**
	 * Retrieves the y-coordinate of this vector.
	 * 
	 * @return the y-coordinate
	 */
	public final double getY() {
		return y;
	}

	/**
	 * Retrieves the z-coordinate of this vector.
	 * 
	 * @return the z-coordinate
	 */
	public final double getZ() {
		return z;
	}

	public boolean equals(Object obj) {
		boolean ret = false;
		if (obj instanceof Vector) {
			Vector vector = (Vector) obj;
			ret = ((Double) vector.getX()).equals(getX())
					&& ((Double) vector.getY()).equals(getY())
					&& ((Double) vector.getZ()).equals(getZ());
		}
		return ret;
	}

	public int hashCode() {
		return ((Double) getX()).hashCode() ^ ((Double) getY()).hashCode()
				^ ((Double) getZ()).hashCode(); 
	}

	public String toString() {
		return String.format("(%.03f, %.03f, %.03f)", getX(), getY(), getZ());
	}
}
