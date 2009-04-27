package lawu.util;

import lawu.Main;

/**
 * @author Miorel-Lucian Palii
 */
public class CloneableObject implements Cloneable {
	@Override
	protected CloneableObject clone() {
		CloneableObject ret = null;
		try {
			ret = (CloneableObject) super.clone();
		}
		catch(CloneNotSupportedException e) {
			throw new Error(Main.getMessage("CloneableObject.0"), e); //$NON-NLS-1$
		}
		return ret;
	}
}
