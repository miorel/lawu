package lawu.ant;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.zip.ZipExtraField;
import org.apache.tools.zip.ZipOutputStream;

public class SelfExtractingJar extends Zip {
	private final static String ARCHIVE_TYPE = "self-extracting jar"; //$NON-NLS-1$
	private final static String PREFIX = "zip"; //$NON-NLS-1$
	private final static String MANIFEST = "Manifest-Version: 1.0\nMain-Class: lawu.app.Main\n"; //$NON-NLS-1$
	private final static int DIR_MODE = 040755;
	private final static int FILE_MODE = 0100644;
	
	public SelfExtractingJar() {
		setClassSpecificAttributes();		
	}

	@Override
	protected void initZipOutputStream(ZipOutputStream zOut) throws IOException, BuildException {
		super.zipDir(null, zOut, PREFIX, DIR_MODE, null);
	}

	@Override
	protected void finalizeZipOutputStream(ZipOutputStream zOut) throws IOException, BuildException {
		super.zipDir(null, zOut, "META-INF", DIR_MODE, null); //$NON-NLS-1$
		super.zipFile(new ByteArrayInputStream(MANIFEST.getBytes()), zOut, "META-INF/MANIFEST.MF", System.currentTimeMillis(), null, FILE_MODE); //$NON-NLS-1$
	}

	@Override
	protected void zipDir(File dir, ZipOutputStream zOut, String vPath, int mode, ZipExtraField[] extra) throws IOException {
		super.zipDir(dir, zOut, PREFIX + '/' + vPath, mode, extra);
	}

	@Override
	protected void zipFile(InputStream in, ZipOutputStream zOut, String vPath, long lastModified, File fromArchive, int mode) throws IOException {
		super.zipFile(in, zOut, PREFIX + '/' + vPath, lastModified, fromArchive, mode);
	}

	@Override
	public void reset() {
		super.reset();
		setClassSpecificAttributes();
	}
	
	private void setClassSpecificAttributes() {
		super.archiveType = ARCHIVE_TYPE;
	}
}