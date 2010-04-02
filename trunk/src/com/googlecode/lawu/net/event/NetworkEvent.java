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

import com.googlecode.lawu.event.Event;
import com.googlecode.lawu.net.SocketClient;

/**
 * Object representation of a network event.
 * 
 * @author Miorel-Lucian Palii
 */
public interface NetworkEvent extends Event<NetworkEventListener> {
	/**
	 * Gets a reference to the client that produced this event.
	 * 
	 * @return this event's producer
	 */
	public SocketClient getClient();
}
