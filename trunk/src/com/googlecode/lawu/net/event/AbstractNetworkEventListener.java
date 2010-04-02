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

/**
 * A stub {@link NetworkEventListener}. It comes with empty method
 * implementations to make listener implementation less verbose, similar to the
 * Swing event adapter classes.
 * 
 * @author Miorel-Lucian Palii
 */
public abstract class AbstractNetworkEventListener implements NetworkEventListener {
	/**
	 * Default constructor, does nothing.
	 */
	public AbstractNetworkEventListener() {
	}
	
	@Override
	public void connected(ConnectedEvent event) {	
	}

	@Override
	public void disconnected(DisconnectedEvent event) {	
	}
	
	@Override
	public void writing(WritingEvent event) {	
	}

	@Override
	public void reading(ReadingEvent event) {
	}
}
