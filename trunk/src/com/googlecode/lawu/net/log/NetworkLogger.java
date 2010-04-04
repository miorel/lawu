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
package com.googlecode.lawu.net.log;

import java.io.IOException;

import com.googlecode.lawu.net.event.ConnectedEvent;
import com.googlecode.lawu.net.event.DisconnectedEvent;
import com.googlecode.lawu.net.event.NetworkEvent;
import com.googlecode.lawu.net.event.NetworkEventListener;
import com.googlecode.lawu.net.event.ReadingEvent;
import com.googlecode.lawu.net.event.WritingEvent;

/**
 * A logger of network events.
 * 
 * @author Miorel-Lucian Palii
 */
public class NetworkLogger implements NetworkEventListener {
	private final Appendable appendable;

	/**
	 * Constructs a logger that will write events to the specified destination.
	 * 
	 * @param appendable
	 *            the destination of log messages
	 */
	public NetworkLogger(Appendable appendable) {
		if(appendable == null)
			throw new NullPointerException("Can't append to null.");
		this.appendable = appendable;
	}
	
	private void log(NetworkEvent event, char identifier, String message) {
		try {
			this.appendable.append(String.format("%1$d %2$s %3$s%3$s%3$s %4$s%n", Long.valueOf(System.currentTimeMillis()), event.getClient().getAddress(), Character.valueOf(identifier), message));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void connected(ConnectedEvent event) {
		log(event, '*', "Connected!");
	}

	@Override
	public void disconnected(DisconnectedEvent event) {
		log(event, '*', "Disconnected.");
	}

	@Override
	public void reading(ReadingEvent event) {
		log(event, '<', event.getMessage());
	}

	@Override
	public void writing(WritingEvent event) {
		log(event, '>', event.getMessage());
	}
}
