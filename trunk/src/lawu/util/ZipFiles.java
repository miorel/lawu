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
package lawu.util;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author Miorel-Lucian Palii
 */
public class ZipFiles {
	private ZipFiles() {
	}
	
	public static void unpack(ZipFile archive) throws IOException {
		unpack(archive, ".*"); //$NON-NLS-1$
	}
	
	public static void unpack(ZipFile archive, String regex) throws IOException {
		unpack(archive, new File("."), regex); //$NON-NLS-1$
	}
	
	public static void unpack(ZipFile archive, File directory) throws IOException {
		unpack(archive, directory, ".*"); //$NON-NLS-1$
	}
	
	public static void unpack(ZipFile archive, File directory, String regex) throws IOException {
		if(archive == null)
			throw new NullPointerException("");
		if(directory == null)
			throw new NullPointerException("");
		if(regex == null)
			throw new NullPointerException("");
		Enumeration<? extends ZipEntry> entries = archive.entries();
		while(entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			if(entry.getName().matches(regex)) {
				File output = new File(directory.getPath() + File.separator + entry.getName());
				if(entry.isDirectory())
					output.mkdirs();
				else
					Files.copy(archive.getInputStream(entry), output, entry.getSize());
			}
		}
	}
}
