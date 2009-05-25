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

import java.io.IOException;
import java.util.jar.JarFile;

import lawu.util.ZipFiles;

/**
 * @author Miorel-Lucian Palii
 *
 */
public class SelfExtract extends StandardApp {
	public SelfExtract(String[] arguments) {
		super(arguments);
	}

	public static void main(String[] arg) {
		new SelfExtract(arg).run();
	}
	
	@Override
	protected void doRun() {
		JarFile jf;
		try {
			jf = new JarFile(SelfExtract.class.getProtectionDomain().getCodeSource().getLocation().getFile());
			ZipFiles.unpack(jf, "unpack\\/.*"); //$NON-NLS-1$
		}
		catch(IOException e) {
		}
	}
}
