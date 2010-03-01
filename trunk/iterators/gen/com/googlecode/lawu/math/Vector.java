import java.util.Comparator;

/**
 * A displacement in three-dimensional space.
 * 
 * @author Miorel-Lucian Palii
 */
public class Vector {
	private final double x; // DATA the x-coordinate
	private final double y; // DATA the y-coordinate
	private final double z; // DATA the z-coordinate

	/**
	 * A comparator that orders vectors by their magnitude. There is no breaking
	 * of ties, so watch out for that if you need a stable sort.
	 */
	public final static Comparator<Vector> MAGNITUDE_ORDER = new Comparator<Vector>() {
		@Override
		public int compare(Vector a, Vector b) {
			return Double.valueOf(a.magnitude()).compareTo(Double.valueOf(b.magnitude()));
		}
	};
	
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
	 * Constructs a vector that has the same coordinates as the argument.
	 * 
	 * @param vector
	 *            the coordinates
	 */
	public Vector(Vector vector) {
		this(vector.getX(), vector.getY(), vector.getZ());
	}

	/**
	 * Returns a new vector object which represents the result of adding this
	 * vector and the argument.
	 * 
	 * @param vector addend
	 * @return this + vector
	 */
	public Vector add(Vector vector) {
		return new Vector(getX() + vector.getX(), getY() + vector.getY(), getZ() + vector.getZ());
	}

	/**
	 * Returns a new vector object which represents the result of subtracting
	 * the argument from this vector.
	 * 
	 * @param vector subtrahend
	 * @return this - vector
	 */
	public Vector subtract(Vector vector) {
		return new Vector(getX() - vector.getX(), getY() - vector.getY(), getZ() - vector.getZ());
	}

	/**
	 * Returns a new vector object which represents the result of multiplying 
	 * this vector by the scalar passed as an argument.
	 * 
	 * @param scalar factor 
	 * @return this * scalar
	 */
	public Vector multiply(double scalar) {
		return new Vector(getX() * scalar, getY() * scalar, getZ() * scalar);
	}

	/**
	 * Returns a new vector object which represents the result of multiplying 
	 * this vector by the inverse of the scalar passed as an argument.
	 * 
	 * @param scalar divisor 
	 * @return this / scalar
	 */
	public Vector divide(double scalar) {
		return new Vector(getX() / scalar, getY() / scalar, getZ() / scalar);
	}
	
	/**
	 * Returns a new vector object which has the same magnitude as this one but
	 * the opposite direction. 
	 * 
	 * @return -this
	 */
	public Vector negate() {
		return new Vector(-getX(), -getY(), -getZ());
	}

	/**
	 * Computes the magnitude of this vector.
	 * 
	 * @return the magnitude of this vector
	 */
	public double magnitude() {
		return Math.hypot(Math.hypot(getX(), getY()), getZ());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long tmp;
		tmp = Double.doubleToLongBits(x);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(y);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(z);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		return result;
	}

	/**
	 * <p>
	 * Indicates whether another object is equal to this vector.
	 * </p>
	 * <p>
	 * To be equal, the object must also be a vector and have the same
	 * coordinates as this one (according to <code>Double.equals()</code>).
	 * There are a couple of cases in which this could get you into trouble, a
	 * subtle one being positive vs. negative zero. A more obvious one would be
	 * rounding error. Therefore, in general, it would probably be more useful
	 * to do comparisons by looking at the magnitude of the difference of two
	 * vectors.
	 * </p>
	 * 
	 * @param o
	 *            the object to check
	 * @return <code>true</code> if the object equals this vector,
	 *         <code>false</code> otherwise
	 */
	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(this == o)
			ret = true;
		else if(o instanceof Vector) {
			Vector other = (Vector) o;
			ret = Double.valueOf(this.x).equals(Double.valueOf(other.x))
				&& Double.valueOf(this.y).equals(Double.valueOf(other.y))
				&& Double.valueOf(this.z).equals(Double.valueOf(other.z));
		}
		return ret;
	}
	
	/**
	 * Returns a string representation of the vector.
	 */
	@Override
	public String toString() {
		return String.format("(%.3f, %.3f, %.3f)", Double.valueOf(getX()), Double.valueOf(getY()), Double.valueOf(getZ()));
	}
}
