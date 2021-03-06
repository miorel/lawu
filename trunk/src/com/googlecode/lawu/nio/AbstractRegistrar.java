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
package com.googlecode.lawu.nio;

import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/**
 * Makes the task of implementing the {@link Registrar} interface marginally
 * easier.
 * 
 * @author Miorel-Lucian Palii
 */
public abstract class AbstractRegistrar implements Registrar {
	/**
	 * Default constructor, does nothing.
	 */
	public AbstractRegistrar() {
	}
	
	@Override
	public SelectionKey register(SelectableChannel channel, int ops) throws ClosedChannelException {
		return register(channel, ops, null);
	}
}
