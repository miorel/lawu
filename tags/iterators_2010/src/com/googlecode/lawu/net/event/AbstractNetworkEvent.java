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

import com.googlecode.lawu.event.AbstractEvent;
import com.googlecode.lawu.net.Client;

public abstract class AbstractNetworkEvent extends AbstractEvent<NetworkEventListener> implements NetworkEvent {
	private final Client client;
	
	public AbstractNetworkEvent(Client client) {
		if(client == null)
			throw new IllegalArgumentException("The client may not be null.");
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
}
