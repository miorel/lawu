package lawu.doclets.internal.toolkit;

import java.io.File;
import java.util.StringTokenizer;

import lawu.doclets.internal.toolkit.builders.AbstractBuilder;
import lawu.doclets.internal.toolkit.builders.BuilderFactory;
import lawu.doclets.internal.toolkit.util.ClassTree;
import lawu.doclets.internal.toolkit.util.DocletConstants;
import lawu.doclets.internal.toolkit.util.PackageListWriter;
import lawu.doclets.internal.toolkit.util.Util;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.LanguageVersion;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.RootDoc;

/**
 * An abstract implementation of a Doclet. This code is not part of an API. It
 * is implementation that is subject to change. Do not use it as an API.
 * 
 * @author Jamie Ho
 */
public abstract class AbstractDoclet {

	/**
	 * The global configuration information for this run.
	 */
	private Configuration configuration = configuration();

	/**
	 * The method that starts the execution of the doclet.
	 * 
	 * @param doclet the doclet to start the execution for.
	 * @param root the {@link RootDoc} that points to the source to document.
	 * @return true if the doclet executed without error. False otherwise.
	 */
	public boolean start(AbstractDoclet doclet, RootDoc root) {
		boolean ret = true;
		this.configuration.root = root;
		try {
			doclet.startGeneration(root);
		}
		catch(Exception e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}

	/**
	 * Indicate that this doclet supports the 1.5 language features.
	 * 
	 * @return JAVA_1_5, indicating that the new features are supported.
	 */
	public static LanguageVersion languageVersion() {
		return LanguageVersion.JAVA_1_5;
	}

	/**
	 * Create the configuration instance and returns it.
	 * 
	 * @return the configuration of the doclet.
	 */
	public abstract Configuration configuration();

	/**
	 * Start the generation of files. Call generate methods in the individual
	 * writers, which will in turn generate the documentation files. Call the
	 * TreeWriter generation first to ensure the Class Hierarchy is built first
	 * and then can be used in the later generation.
	 * 
	 * @see com.sun.javadoc.RootDoc
	 */
	private void startGeneration(RootDoc root) throws Exception {
		if(root.classes().length == 0) {
			this.configuration.message
					.error("doclet.No_Public_Classes_To_Document"); //$NON-NLS-1$
			return;
		}
		this.configuration.setOptions();
		this.configuration.getDocletSpecificMsg().notice(
				"doclet.build_version", //$NON-NLS-1$
				this.configuration.getDocletSpecificBuildDate());
		ClassTree classtree = new ClassTree(this.configuration,
				this.configuration.nodeprecated);

		generateClassFiles(root, classtree);
		if(this.configuration.sourcepath != null
				&& this.configuration.sourcepath.length() > 0) {
			StringTokenizer pathTokens = new StringTokenizer(
					this.configuration.sourcepath, File.pathSeparator);
			boolean first = true;
			while(pathTokens.hasMoreTokens()) {
				Util.copyDocFiles(this.configuration, pathTokens.nextToken()
						+ File.separator, DocletConstants.DOC_FILES_DIR_NAME,
						first);
				first = false;
			}
		}

		PackageListWriter.generate(this.configuration);
		generatePackageFiles(classtree);

		generateOtherFiles(root, classtree);
		this.configuration.tagletManager.printReport();
	}

	/**
	 * Generate additional documentation that is added to the API documentation.
	 * 
	 * @param root the RootDoc of source to document.
	 * @param classtree the data structure representing the class tree.
	 */
	protected void generateOtherFiles(@SuppressWarnings("unused") RootDoc root,
			@SuppressWarnings("unused") ClassTree classtree) throws Exception {
		BuilderFactory builderFactory = this.configuration.getBuilderFactory();
		AbstractBuilder constantsSummaryBuilder = builderFactory
				.getConstantsSummaryBuider();
		constantsSummaryBuilder.build();
		AbstractBuilder serializedFormBuilder = builderFactory
				.getSerializedFormBuilder();
		serializedFormBuilder.build();
	}

	/**
	 * Generate the package documentation.
	 * 
	 * @param classtree the data structure representing the class tree.
	 */
	protected abstract void generatePackageFiles(ClassTree classtree)
			throws Exception;

	/**
	 * Generate the class documentation.
	 * 
	 * @param classtree the data structure representing the class tree.
	 */
	protected abstract void generateClassFiles(ClassDoc[] arr,
			ClassTree classtree);

	/**
	 * Iterate through all classes and construct documentation for them.
	 * 
	 * @param root the RootDoc of source to document.
	 * @param classtree the data structure representing the class tree.
	 */
	protected void generateClassFiles(RootDoc root, ClassTree classtree) {
		generateClassFiles(classtree);
		PackageDoc[] packages = root.specifiedPackages();
		for(int i = 0; i < packages.length; i++) {
			generateClassFiles(packages[i].allClasses(), classtree);
		}
	}

	/**
	 * Generate the class files for single classes specified on the command
	 * line.
	 * 
	 * @param classtree the data structure representing the class tree.
	 */
	private void generateClassFiles(ClassTree classtree) {
		String[] packageNames = this.configuration.classDocCatalog
				.packageNames();
		for(int packageNameIndex = 0; packageNameIndex < packageNames.length; packageNameIndex++) {
			generateClassFiles(this.configuration.classDocCatalog
					.allClasses(packageNames[packageNameIndex]), classtree);
		}
	}
}
