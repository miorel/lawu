/**
 * 
 */
package lawu.ant;

import java.io.File;
import java.io.IOException;

import lawu.app.SoftwareInfo;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * @author Miorel-Lucian Palii
 */
public class DistributionName extends Task {
	private File file;
	private String outputProperty;
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void setOutputProperty(String outputProperty) {
		this.outputProperty = outputProperty;
	}
	
	@Override
	public void execute() {
		if(this.file == null)
			throw new BuildException(getTaskType() + " needs file attribute", getLocation());
		if(this.file == null)
			throw new BuildException(getTaskType() + " needs outputproperty attribute", getLocation());
		SoftwareInfo info;
		try {
			info = new SoftwareInfo(this.file);
		}
		catch(IOException e) {
			throw new BuildException(e);
		}
		String name = info.getName();
		String version = info.getVersion();
		String val = name;
		if(version != null)
			val += '-' + version;
		getProject().setNewProperty(this.outputProperty, val);
	}
}
