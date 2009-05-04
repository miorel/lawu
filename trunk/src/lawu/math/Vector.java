package lawu.math;

import lawu.Main;

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
	 * Constructs a vector that has the same coordinates as the argument.
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
	public double getX() {
		return this.x;
	}

	/**
	 * Retrieves the y-coordinate of this vector.
	 * 
	 * @return the y-coordinate
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * Retrieves the z-coordinate of this vector.
	 * 
	 * @return the z-coordinate
	 */
	public double getZ() {
		return this.z;
	}

	/**
	 * Returns a new vector object which represents the result of adding this
	 * vector and the argument.
	 * 
	 * @param vector addend
	 * @return this + vector
	 */
	public Vector add(Vector vector) {
		return new Vector(getX() + vector.getX(), getY() + vector.getY(),
				getZ() + vector.getZ());
	}

	/**
	 * Returns a new vector object which represents the result of subtracting
	 * the argument from this vector.
	 * 
	 * @param vector subtrahend
	 * @return this - vector
	 */
	public Vector subtract(Vector vector) {
		return new Vector(getX() - vector.getX(), getY() - vector.getY(),
				getZ() - vector.getZ());
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(this == obj)
			ret = true;
		else if(obj instanceof Vector) {
			Vector other = (Vector) obj;
			ret = Double.valueOf(this.x).equals(Double.valueOf(other.x))
				&& Double.valueOf(this.y).equals(Double.valueOf(other.y))
				&& Double.valueOf(this.z).equals(Double.valueOf(other.z));
		}
		return ret;
	}
	
	@Override
	@SuppressWarnings("boxing")
	public String toString() {
		return String.format(Main.getString("Vector.0"), getX(), getY(), getZ()); //$NON-NLS-1$
	}
}
