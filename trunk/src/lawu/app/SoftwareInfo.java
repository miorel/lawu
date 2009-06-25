/*
 * lawu
 * Copyright (C) 2009 Miorel-Lucian Palii
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
package lawu.app;

import static lawu.cli.VersionOption.formatCopyright;
import static lawu.cli.VersionOption.formatVersionString;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Miorel-Lucian Palii
 */
public class SoftwareInfo {
	private String name;
	private String version;
	private String copyright;

	public SoftwareInfo() {
	}
	
	public SoftwareInfo(String name, String version) {
		setName(name);
		setVersion(version);
	}

	public SoftwareInfo(Properties properties) {
		setAttributesFromProperties(properties);
	}

	public SoftwareInfo(Class<?> c) throws IOException {
		this(getPropertiesFromInputStream(c.getClassLoader().getResourceAsStream(c.getName().replace('.', '/') + ".properties"))); //$NON-NLS-1$
	}
	
	private static final Properties getPropertiesFromInputStream(InputStream stream) throws IOException {
		Properties prop = new Properties();
		prop.load(stream);
		return prop;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getCopyright() {
		return this.copyright;
	}
	
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
	public void setAttributesFromProperties(Class<?> c) {
		Properties properties = new Properties();
		String resource = c.getName().replace('.', '/') + ".properties"; //$NON-NLS-1$
		InputStream stream = c.getClassLoader().getResourceAsStream(resource);
		if(stream != null)
			try {
				properties.load(stream);
			}
			catch(IOException e) {
			}
		setAttributesFromProperties(properties);
	}
	
	public void setAttributesFromProperties(Properties properties) {
		setName(properties.getProperty("name", getName())); //$NON-NLS-1$
		String tVersion = properties.getProperty("version"); //$NON-NLS-1$
		if(tVersion != null)
			this.version = tVersion;
		else {
			String tVersionMajor = properties.getProperty("version_major"); //$NON-NLS-1$
			if(tVersionMajor != null) {
				int tVMajor = Integer.parseInt(tVersionMajor);
				String tVersionMinor = properties.getProperty("version_major"); //$NON-NLS-1$
				if(tVersionMinor != null) {
					int tVMinor = Integer.parseInt(tVersionMinor);
					String tVersionBuild = properties.getProperty("version_build"); //$NON-NLS-1$
					if(tVersionBuild != null) {
						int tVBuild = Integer.parseInt(tVersionBuild);
						String tVersionRevision = properties.getProperty("version_revision"); //$NON-NLS-1$
						if(tVersionRevision != null) {
							int tVRevision = Integer.parseInt(tVersionRevision);
							setVersion(formatVersionString(tVMajor, tVMinor, tVBuild, tVRevision));
						}
						else
							setVersion(formatVersionString(tVMajor, tVMinor, tVBuild));
					}
					else
						setVersion(formatVersionString(tVMajor, tVMinor));
				}
				else
					setVersion(formatVersionString(tVMajor));
			}
		}
		setVersion(properties.getProperty("version", getVersion())); //$NON-NLS-1$
		String tCopyright = properties.getProperty("copyright"); //$NON-NLS-1$
		if(tCopyright != null)
			this.copyright = tCopyright;
		else {
			String tHolder = properties.getProperty("copyright_holder"); //$NON-NLS-1$
			String tDate = properties.getProperty("copyright_date"); //$NON-NLS-1$
			String tYear = properties.getProperty("copyright_year"); //$NON-NLS-1$
			if(tHolder != null)
				if(tDate != null)
					setCopyright(formatCopyright(tHolder, tDate));
				else if(tYear != null)
					setCopyright(formatCopyright(tHolder, Integer.parseInt(tYear)));
		}
	}
}
