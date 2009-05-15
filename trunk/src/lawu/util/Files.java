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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class Files {
	private Files() {
	}
	
    public static void copy(File source, File destination) throws IOException {
		FileInputStream sourceStream = new FileInputStream(source);
		destination.getParentFile().mkdirs();
		FileOutputStream destStream = new FileOutputStream(destination);
		try {
			FileChannel sourceChannel = sourceStream.getChannel();
			FileChannel destChannel = destStream.getChannel();
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		}
		finally {
			sourceStream.close();
			destStream.close();
		}
	}

    public static void copy(InputStream source, File destination) throws IOException {
		ReadableByteChannel sourceChannel = Channels.newChannel(source);
		destination.getParentFile().mkdirs();
		FileOutputStream destStream = new FileOutputStream(destination);
		try {
			FileChannel destChannel = destStream.getChannel();
			destChannel.transferFrom(sourceChannel, 0, Long.MAX_VALUE);
		}
		finally {
			source.close();
			destStream.close();
		}
	}
}
