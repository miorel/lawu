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
package com.googlecode.lawu.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.LinkedList;
import java.util.Queue;

import com.googlecode.lawu.nio.Registrar;

public abstract class Client {
	public static final String CHARSET_NAME = "US-ASCII";
	public static final int BUFFER_SIZE = 1 << 12;
	public static final long CONNECTION_TIMEOUT = 10000;
	
	private final Registrar registrar;
	private final SelectorProvider provider;
	private final InetSocketAddress address;
	private SocketChannel channel;
	
	private final Queue<String> outputQueue;

	private final ByteBuffer byteBuffer;
	private final CharBuffer charBuffer;
	private final StringBuilder stringBuffer;

	private final CharsetDecoder decoder;
	private final CharsetEncoder encoder;

	public Client(InetSocketAddress address, Registrar registrar) {
		this(address, registrar, null);
	}
	
	public Client(InetSocketAddress address, Registrar registrar, SelectorProvider provider) {
		if(address == null)
			throw new IllegalArgumentException("The address may not be null.");
		if(registrar == null)
			throw new IllegalArgumentException("The registrar may not be null.");
		this.address = address;
		this.registrar = registrar;
		this.provider = provider == null ? SelectorProvider.provider() : provider;
		this.outputQueue = new LinkedList<String>();
		this.byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
		this.charBuffer = CharBuffer.allocate(BUFFER_SIZE);
		this.stringBuffer = new StringBuilder();
		Charset charset = Charset.forName(CHARSET_NAME);
		this.decoder = charset.newDecoder();
		this.encoder = charset.newEncoder();
	}
	
	public InetSocketAddress getAddress() {
		return address;
	}

	private void setChannelInterest(int ops) throws ClosedChannelException {
		synchronized(stringBuffer) {
			registrar.register(channel, ops, this);
		}
	}

	private void listenForConnect() throws ClosedChannelException {
		setChannelInterest(SelectionKey.OP_CONNECT);
	}

	private void listenForRead() throws ClosedChannelException {
		setChannelInterest(SelectionKey.OP_READ);
	}

	private void listenForReadWrite() throws ClosedChannelException {
		setChannelInterest(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
	}
	
	public void prepare() throws IOException {
		synchronized(stringBuffer) {
			synchronized(outputQueue) {
				outputQueue.clear();
			}
			disconnect();
			channel = provider.openSocketChannel();
			channel.configureBlocking(false);
			channel.connect(address);
			listenForConnect();
		}
	}
	
	public void connect() throws IOException {
		synchronized(stringBuffer) {
			if(channel.isConnectionPending() && channel.finishConnect())
				listenForReadWrite();
		}
	}
	
	public void disconnect() {
		synchronized(stringBuffer) {
			try {
				SocketChannel tmp = channel;
				if(tmp != null) {
					channel = null;
					tmp.socket().close();
				}
			}
			catch(IOException e) {
				report(e);
			}
		}
	}
	
	protected void report(Throwable t) {
		t.printStackTrace();
	}
	
	public void read() throws IOException {
		synchronized(stringBuffer) {
			if(channel.read(byteBuffer) < 0)
				disconnect();
			else {
				byteBuffer.flip();
				decoder.decode(byteBuffer, charBuffer, false);
				charBuffer.flip();
				stringBuffer.append(charBuffer);
				byteBuffer.clear();
				charBuffer.clear();
				scanBuffer(stringBuffer);
			}
		}
	}
	
	public void write() throws IOException {
		synchronized(stringBuffer) {
			String message;
			synchronized(outputQueue) {
				message = outputQueue.poll();
				if(outputQueue.isEmpty()) {
					try {
						listenForRead();
					}
					catch(ClosedChannelException e) {
						report(e);
					}
				}
			}
			if(message != null)
				channel.write(encoder.encode(CharBuffer.wrap(message)));
		}
	}
	
	protected abstract void scanBuffer(StringBuilder buffer);
	
	public void send(String message) {
		synchronized(outputQueue) {
			outputQueue.add(message);
			try {
				listenForReadWrite();
			}
			catch(ClosedChannelException e) {
				report(e);
			}
		}
	}
}
