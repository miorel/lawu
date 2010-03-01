/*
 * Copyright (C) 2010 Miorel-Lucian Palii
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
package com.googlecode.lawu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class Streams {
	private Streams() {
	}

	public static void copy(File source, File destination) throws IOException {
		if(source == null)
			throw new IllegalArgumentException("The source may not be null.");
		if(destination == null)
			throw new IllegalArgumentException("The destination may not be null.");
		FileInputStream sourceStream = new FileInputStream(source);
		destination.getParentFile().mkdirs();
		FileOutputStream destStream = new FileOutputStream(destination);
		try {
			FileChannel sourceChannel = sourceStream.getChannel();
			FileChannel destChannel = destStream.getChannel();
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		}
		finally {
			try {
				sourceStream.close();
				destStream.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void copy(InputStream source, File destination, long size) throws IOException {
		if(source == null)
			throw new IllegalArgumentException("The source may not be null.");
		if(destination == null)
			throw new IllegalArgumentException("The destination may not be null.");
		if(size < 0)
			throw new IllegalArgumentException("The size may not be negative.");
		ReadableByteChannel sourceChannel = Channels.newChannel(source);
		try {
			destination.getParentFile().mkdirs();
			destination.getAbsoluteFile().getParentFile().mkdirs();
		}
		catch(Exception e) {}
		FileOutputStream destStream = new FileOutputStream(destination);
		try {
			FileChannel destChannel = destStream.getChannel();
			destChannel.transferFrom(sourceChannel, 0, size);
		}
		finally {
			try {
				source.close();
				destStream.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void copy(InputStream source, File destination) throws IOException {
		Streams.copy(source, destination, Long.MAX_VALUE);
	}
	
    public static StringBuilder slurp(InputStream stream) throws IOException {
		InputStreamReader reader = new InputStreamReader(stream);
		StringBuilder ret = new StringBuilder();
		char[] buf = new char[1 << 12];
		try {
			for(int n; (n = reader.read(buf)) != -1;)
				ret.append(new String(buf, 0, n));
		}
		finally {
			try {
				stream.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			try {
				reader.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public static StringBuilder slurp(File file) throws FileNotFoundException, IOException {
		return slurp(new FileInputStream(file));
	}

	public static StringBuilder slurp(String path) throws FileNotFoundException, IOException {
		return slurp(new FileInputStream(path));
	}
	
	public static StringBuilder slurp(URL url) throws IOException {
		return slurp(url.openStream());
	}
}
