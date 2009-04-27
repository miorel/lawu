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
		return this.x;
	}

	/**
	 * Retrieves the y-coordinate of this vector.
	 * 
	 * @return the y-coordinate
	 */
	public final double getY() {
		return this.y;
	}

	/**
	 * Retrieves the z-coordinate of this vector.
	 * 
	 * @return the z-coordinate
	 */
	public final double getZ() {
		return this.z;
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
		else if(getClass() == obj.getClass()) {
			Vector other = (Vector) obj;
			ret = true;
			if(Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x))
				ret = false;
			if(Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y))
				ret = false;
			if(Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z))
				ret = false;
		}
		return ret;
	}
	
	@Override
	@SuppressWarnings("boxing")
	public String toString() {
		return String.format(Main.getMessage("Vector.0"), getX(), getY(), getZ()); //$NON-NLS-1$
	}
}
