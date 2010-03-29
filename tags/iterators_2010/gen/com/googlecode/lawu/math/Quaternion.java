import java.util.Comparator;

/**
 * @author Miorel-Lucian Palii
 *
 */
public class Quaternion {
	private final double w; // DATA the w-coordinate
	private final double x; // DATA the x-coordinate
	private final double y; // DATA the y-coordinate
	private final double z; // DATA the z-coordinate

	/**
	 * A comparator that orders quaternions by their magnitude. There is no
	 * breaking of ties, so watch out for that if you need a stable sort.
	 */
	public final static Comparator<Quaternion> MAGNITUDE_ORDER = new Comparator<Quaternion>() {
		@Override
		public int compare(Quaternion a, Quaternion b) {
			return Double.valueOf(a.magnitude()).compareTo(Double.valueOf(b.magnitude()));
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
		return new Quaternion(getW() + quaternion.getW(), getX() + quaternion.getX(), getY() + quaternion.getY(), getZ() + quaternion.getZ());
	}

	/**
	 * Returns a new quaternion object which represents the result of subtracting
	 * the argument from this quaternion.
	 * 
	 * @param quaternion subtrahend
	 * @return this - quaternion
	 */
	public Quaternion subtract(Quaternion quaternion) {
		return new Quaternion(getW() - quaternion.getW(), getX() - quaternion.getX(), getY() - quaternion.getY(), getZ() - quaternion.getZ());
	}

	/**
	 * Returns a new quaternion object which represents the result of
	 * multiplying this quaternion by the scalar passed as an argument.
	 * 
	 * @param scalar factor
	 * @return this * scalar
	 */
	public Quaternion multiply(double scalar) {
		return new Quaternion(getW() * scalar, getX() * scalar, getY() * scalar, getZ() * scalar);
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
		return new Quaternion(getW() / scalar, getX() / scalar, getY() / scalar, getZ() / scalar);
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(w);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * <p>
	 * Indicates whether another object is equal to this quaternion.
	 * </p>
	 * <p>
	 * To be equal, the object must also be a quaternion and have the same
	 * coordinates as this one (according to <code>Double.equals()</code>).
	 * There are a couple of cases in which this could get you into trouble, a
	 * subtle one being positive vs. negative zero. A more obvious one would be
	 * rounding error. Therefore, in general, it would probably be more useful
	 * to do comparisons by looking at the magnitude of the difference of two
	 * quaternions.
	 * </p>
	 */
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
	
	/**
	 * Returns a string representation of the quaternion.
	 */
	@Override
	public String toString() {
		return String.format("(%.3f, %.3f, %.3f, %.3f)", Double.valueOf(getW()), Double.valueOf(getX()), Double.valueOf(getY()), Double.valueOf(getZ()));
	}
}
