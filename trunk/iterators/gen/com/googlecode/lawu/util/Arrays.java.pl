%_ = qw(
	long Long
	short Short
	int	Integer
	char Character
	byte Byte
	float Float
	double Double
);

print while <DATA>;

while(my($key, $value) = each %_) {
	print <<"METHOD";

	/**
	 * Boxes a <code>$key</code> array as a <code>$value</code> array.
	 * 
	 * \@param array
	 *            the array to box
	 * \@return a boxed copy of the array
	 */
	public static ${value}[] box(${key}[] array) {
		${value}[] ret = new ${value}[array.length];
		for(int i = array.length; --i >= 0;)
			ret[i] = $value.valueOf(array[i]);
		return ret;
	}
METHOD
}

print "}\n";

__DATA__
public class Arrays {
	private Arrays() {
	}
