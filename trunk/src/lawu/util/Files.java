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
