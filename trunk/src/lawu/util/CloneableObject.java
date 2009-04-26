package lawu.util;

public class CloneableObject implements Cloneable {
	protected CloneableObject clone() {
		CloneableObject ret = null;
		try {
			ret = (CloneableObject) super.clone();
		}
		catch(CloneNotSupportedException e) {
			throw new Error("A cloneable object threw a CNSE!", e);
		}
		return ret;
	}
}
