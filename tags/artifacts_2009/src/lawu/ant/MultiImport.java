/**
 * 
 */
package lawu.ant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.taskdefs.ImportTask;
import org.apache.tools.ant.types.FileSet;

/**
 * @author Miorel-Lucian Palii
 */
public class MultiImport extends ImportTask {
	private final List<FileSet> filesets = new ArrayList<FileSet>();
	
	@Override
	public void setFile(String filename) {
        FileSet fs = new FileSet();
        fs.setFile(new File(filename));
        addFileset(fs);
	}
	
	public void addFileset(FileSet fileset) {
		if(fileset == null)
			throw new BuildException("can't add null fileset to " + getTaskType(), getLocation());
		this.filesets.add(fileset);
	}
	
	@Override
	public void execute() {
		for(FileSet fs: this.filesets) {
			DirectoryScanner ds = fs.getDirectoryScanner(getProject());
			for(String file: ds.getIncludedFiles()) {
				super.setFile(new File(ds.getBasedir(), file).getPath());
				super.execute();
	        }
		}
	}
}
