package lawu;

/**
 * Houses the <code>main</code> method.
 * 
 * @author Miorel-Lucian Palii
 */
public class RunApp {
	private RunApp(String... opts) {
	}

	private void run() {
		System.out.println("This is not a stand-alone executable but rather a library to be used by other programs.");
	}

	/**
	 * Entry point for project execution.
	 * 
	 * @param arg
	 *            command-line options
	 */
	public static void main(String[] arg) {
		new RunApp(arg).run();
	}
}
