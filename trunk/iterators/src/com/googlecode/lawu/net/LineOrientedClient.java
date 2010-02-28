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

import java.net.InetSocketAddress;
import java.nio.channels.spi.SelectorProvider;

import com.googlecode.lawu.nio.Registrar;

public abstract class LineOrientedClient extends Client {
	public LineOrientedClient(InetSocketAddress address, Registrar registrar, SelectorProvider provider) {
		super(address, registrar, provider);
	}

	public LineOrientedClient(InetSocketAddress address, Registrar registrar) {
		super(address, registrar);
	}

	@Override
	public void send(String message) {
		super.send(message + "\r\n");
	}
	
	@Override
	protected void scanBuffer(StringBuilder buffer) {
		for(int i = 0; i < buffer.length(); ++i) {
			char c = buffer.charAt(i);
			if(c == '\r' || c == '\n') {
				String line = buffer.substring(0, i);
				do ++i;
				while(i < buffer.length() && (buffer.charAt(i) == '\r' || buffer.charAt(i) == '\n'));
				buffer.delete(0, i);
				i = -1;
				process(line);
			}
		}
	}

	protected abstract void process(String line);
}