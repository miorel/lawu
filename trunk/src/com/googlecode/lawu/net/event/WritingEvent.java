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
package com.googlecode.lawu.net.event;

import com.googlecode.lawu.net.SocketClient;

/**
 * Raised when an outgoing message is written to a socket.
 * 
 * @author Miorel-Lucian Palii
 */
public class WritingEvent extends MessageEvent {
	/**
	 * Constructs an outgoing message event associated with the given client.
	 * 
	 * @param client
	 *            the client to associate with
	 * @param message
	 *            the outgoing message
	 */
	public WritingEvent(SocketClient client, String message) {
		super(client, message);
	}
	
	@Override
	protected void doTrigger(NetworkEventListener listener) {
		listener.writing(this);
	}
}
