/**
 * 
 */
package lawu.app;

/**
 * @author Miorel-Lucian Palii
 */
public abstract class AbstractSoftwareElement implements SoftwareElement {
	private final SoftwareInfo info;
	
	public AbstractSoftwareElement(SoftwareInfo info) {
		if(info == null)
			throw new RuntimeException("");
		this.info = info.clone();
	}
	
	public AbstractSoftwareElement() {
		this.info = new SoftwareInfo(getClass().getSimpleName(), "(pre-alpha)"); //$NON-NLS-1$
	}
	
	public final SoftwareInfo getInfo() {
		return getActualInfo().clone();
	}
	
	protected final SoftwareInfo getActualInfo() { 
		return this.info;
	}
}
