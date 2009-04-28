/**
 * 
 */
package lawu;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Houses the <code>main</code> method and serves as access point for program
 * messages.
 * 
 * @author Miorel-Lucian Palii
 */
public class Main {
	private static final String BUNDLE_NAME = "lawu.nls.message"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE;
	
	static {
		ResourceBundle rb;
		try {
			rb = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		catch(MissingResourceException e) {
			rb = null;
		}
		RESOURCE_BUNDLE = rb;
	}

	private Main() {
		// no initialization work necessary
	}

	private void run() {
		System.out.println(getMessage("RunApp.0")); //$NON-NLS-1$
		//Desktop.getDesktop().browse(new URI("http://www.google.com/"));
	}
	
	/**
	 * Entry point for project execution.
	 * 
	 * @param arg command-line options
	 */
	public static void main(String[] arg) {
		new Main().run();
	}
	
	/**
	 * @param key
	 * @return
	 */
	public static String getMessage(String key) {
		String ret; 
		try {
			ret = RESOURCE_BUNDLE.getString(key);
		}
		catch(Exception e) {
			ret = '!' + key + '!';
		}
		return ret;
	}
}
