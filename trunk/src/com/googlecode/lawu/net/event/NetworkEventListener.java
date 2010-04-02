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

import com.googlecode.lawu.event.EventListener;

/**
 * An object that reacts to network events.
 * 
 * @author Miorel-Lucian Palii
 */
public interface NetworkEventListener extends EventListener {
	/**
	 * Defines how this listener reacts to a connection event.
	 * 
	 * @param event
	 *            the connection event
	 */
	public void connected(ConnectedEvent event);
	
	/**
	 * Defines how this listener reacts to a disconnection event.
	 * 
	 * @param event
	 *            the disconnection event
	 */
	public void disconnected(DisconnectedEvent event);

	/**
	 * Defines how this listener reacts to an incoming message.
	 * 
	 * @param event
	 *            an event wrapper for the incoming message
	 */
	public void reading(ReadingEvent event);
	
	/**
	 * Defines how this listener reacts to an outgoing message.
	 * 
	 * @param event
	 *            an event wrapper for the outgoing message
	 */
	public void writing(WritingEvent event);
}
