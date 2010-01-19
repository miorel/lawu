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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.Properties;
import java.util.ResourceBundle;

import lawu.util.CloneableObject;
import lawu.util.ResourceBundleAdapter;

/**
 * @author Miorel-Lucian Palii
 */
public class SoftwareInfo extends CloneableObject {
	private String name;
	private String version;
	private String copyright;
	
	private String bugReportEmail;
	private String homePage;
	
	public SoftwareInfo() {
	}
	
	public SoftwareInfo(String name, String version) {
		setName(name);
		setVersion(version);
	}
	
	public SoftwareInfo(String name, String version, String copyright) {
		this(name, version);
		setCopyright(copyright);
	}

	public SoftwareInfo(Properties properties) {
		setAttributesFromDictionary(properties);
	}

	public SoftwareInfo(ResourceBundle bundle) {
		setAttributesFromResourceBundle(bundle);
	}
	
	public SoftwareInfo(Class<?> c) {
		setAttributesFromClass(c);
	}

	public SoftwareInfo(InputStream stream) throws IOException {
		Properties properties = new Properties();
		properties.load(stream);
		setAttributesFromDictionary(properties);
	}
	
	public SoftwareInfo(File file) throws FileNotFoundException, IOException {
		this(new FileInputStream(file));
	}
	
	@Override
	public SoftwareInfo clone() {
		return (SoftwareInfo) super.clone();
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
	
	public String getBugReportEmail() {
		return this.bugReportEmail;
	}
	
	public void setBugReportEmail(String bugReportEmail) {
		this.bugReportEmail = bugReportEmail;
	}

	public String getHomePage() {
		return this.homePage;
	}
	
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	
	public void setAttributesFromClass(Class<?> c) {
		setAttributesFromResourceBundle(ResourceBundle.getBundle(c.getName(), ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_PROPERTIES)));
	}
	
	public void setAttributesFromResourceBundle(ResourceBundle bundle) {
		setAttributesFromDictionary(new ResourceBundleAdapter(bundle));
	}
	
	public void setAttributesFromDictionary(Dictionary<? extends Object, ? extends Object> properties) {
		setName(getProperty(properties, "name", getName())); //$NON-NLS-1$
		setHomePage(getProperty(properties, "home_page", getHomePage())); //$NON-NLS-1$
		setBugReportEmail(getProperty(properties, "bug_report_email", getBugReportEmail())); //$NON-NLS-1$
		String tVersion = getProperty(properties, "version"); //$NON-NLS-1$
		if(tVersion != null)
			this.version = tVersion;
		else {
			String tVersionMajor = getProperty(properties, "version_major"); //$NON-NLS-1$
			if(tVersionMajor != null) {
				int tVMajor = Integer.parseInt(tVersionMajor);
				String tVersionMinor = getProperty(properties, "version_major"); //$NON-NLS-1$
				if(tVersionMinor != null) {
					int tVMinor = Integer.parseInt(tVersionMinor);
					String tVersionBuild = getProperty(properties, "version_build"); //$NON-NLS-1$
					if(tVersionBuild != null) {
						int tVBuild = Integer.parseInt(tVersionBuild);
						String tVersionRevision = getProperty(properties, "version_revision"); //$NON-NLS-1$
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
		setVersion(getProperty(properties, "version", getVersion())); //$NON-NLS-1$
		String tCopyright = getProperty(properties, "copyright"); //$NON-NLS-1$
		if(tCopyright != null)
			this.copyright = tCopyright;
		else {
			String tHolder = getProperty(properties, "copyright_holder"); //$NON-NLS-1$
			String tDate = getProperty(properties, "copyright_date"); //$NON-NLS-1$
			String tYear = getProperty(properties, "copyright_year"); //$NON-NLS-1$
			if(tHolder != null)
				if(tDate != null)
					setCopyright(formatCopyright(tHolder, tDate));
				else if(tYear != null)
					setCopyright(formatCopyright(tHolder, Integer.parseInt(tYear)));
		}
	}
	
	private static String getProperty(Dictionary<?, ?> map, String key) {
		return getProperty(map, key, null);
	}
	
	private static String getProperty(Dictionary<?, ?> map, String key, String defaultValue) {
		Object val = map.get(key);
		return val == null ? defaultValue : val.toString();
	}
}
