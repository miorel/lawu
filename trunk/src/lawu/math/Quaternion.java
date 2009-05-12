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

import java.util.Comparator;

/**
 * @author Miorel-Lucian Palii
 *
 */
public class Quaternion {
	private final double w;
	private final double x;
	private final double y;
	private final double z;

	public final static Comparator<Quaternion> MAGNITUDE_ORDER = new Comparator<Quaternion>() {
		@Override
		public int compare(Quaternion a, Quaternion b) {
			return Double.valueOf(a.magnitude()).compareTo(
					Double.valueOf(b.magnitude()));
		}
	};
	
	/**
	 * Constructs a zero quaternion.
	 */
	public Quaternion() {
		this(0, 0, 0, 0);
	}

	/**
	 * Constructs a quaternion with the specified coordinates.
	 * 
	 * @param w the w-coordinate
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 * @param z the z-coordinate
	 */
	public Quaternion(double w, double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Constructs a pure imaginary (vector-only) quaternion that represents the
	 * specified vector.
	 * 
	 * @param vector the vector to represent
	 */
	public Quaternion(Vector vector) {
		this(0, vector.getX(), vector.getY(), vector.getZ());
	}

	/**
	 * Constructs a real (scalar-only) quaternion that represents the specified
	 * scalar.
	 * 
	 * @param scalar the scalar to represent
	 */
	public Quaternion(double scalar) {
		this(scalar, 0, 0, 0);
	}
	
	/**
	 * Retrieves the w-coordinate of this quaternion.
	 * 
	 * @return the w-coordinate
	 */
	public double getW() {
		return this.w;
	}
	
	/**
	 * Retrieves the x-coordinate of this quaternion.
	 * 
	 * @return the x-coordinate
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * Retrieves the y-coordinate of this quaternion.
	 * 
	 * @return the y-coordinate
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * Retrieves the z-coordinate of this quaternion.
	 * 
	 * @return the z-coordinate
	 */
	public double getZ() {
		return this.z;
	}
	
	/**
	 * Gets the vector portion of this quaternion.
	 * 
	 * @return a vector (x, y, z)
	 */
	public Vector getVector() {
		return new Vector(getX(), getY(), getZ());
	}
	
	/**
	 * Gets the scalar portion of this quaternion. This is a synonym for
	 * <code>getW()</code>, included for orthogonality with
	 * <code>getVector()</code>.
	 * 
	 * @return the w-coordinate
	 */
	public double getScalar() {
		return getW();
	}
	
	/**
	 * Returns a new quaternion object which represents the result of adding this
	 * quaternion and the argument.
	 * 
	 * @param quaternion addend
	 * @return this + quaternion
	 */
	public Quaternion add(Quaternion quaternion) {
		return new Quaternion(getW() + quaternion.getW(), getX()
				+ quaternion.getX(), getY() + quaternion.getY(), getZ()
				+ quaternion.getZ());
	}

	/**
	 * Returns a new quaternion object which represents the result of subtracting
	 * the argument from this quaternion.
	 * 
	 * @param quaternion subtrahend
	 * @return this - quaternion
	 */
	public Quaternion subtract(Quaternion quaternion) {
		return new Quaternion(getW() - quaternion.getW(), getX()
				- quaternion.getX(), getY() - quaternion.getY(), getZ()
				- quaternion.getZ());
	}

	/**
	 * Returns a new quaternion object which represents the result of
	 * multiplying this quaternion by the scalar passed as an argument.
	 * 
	 * @param scalar factor
	 * @return this * scalar
	 */
	public Quaternion multiply(double scalar) {
		return new Quaternion(getW() * scalar, getX() * scalar,
				getY() * scalar, getZ() * scalar);
	}

	/**
	 * Returns a new quaternion object which represents the result of
	 * multiplying this quaternion by the inverse of the scalar passed as an
	 * argument.
	 * 
	 * @param scalar divisor
	 * @return this / scalar
	 */
	public Quaternion divide(double scalar) {
		return new Quaternion(getW() / scalar, getX() / scalar,
				getY() / scalar, getZ() / scalar);
	}
	
	/**
	 * Returns a new quaternion object which has the same magnitude as this one
	 * but the opposite direction.
	 * 
	 * @return -this
	 */
	public Quaternion negate() {
		return new Quaternion(-getW(), -getX(), -getY(), -getZ());
	}

	/**
	 * Computes the magnitude of this quaternion.
	 * 
	 * @return the magnitude of this quaternion
	 */
	public double magnitude() {
		return Math.hypot(getW(), getVector().magnitude());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.w);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		else if(obj instanceof Quaternion) {
			Quaternion other = (Quaternion) obj;
			ret = Double.valueOf(this.w).equals(Double.valueOf(other.w))
				&& Double.valueOf(this.x).equals(Double.valueOf(other.x))
				&& Double.valueOf(this.y).equals(Double.valueOf(other.y))
				&& Double.valueOf(this.z).equals(Double.valueOf(other.z));
		}
		return ret;
	}
	
	@Override
	@SuppressWarnings("boxing")
	public String toString() {
		return String.format("Quaternion.0", getW(), getX(), getY(), getZ()); //$NON-NLS-1$
	}
}
