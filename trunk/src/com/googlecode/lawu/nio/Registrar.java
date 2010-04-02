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
import java.nio.channels.Selector;

/**
 * Mediator between {@link SelectableChannel}s and {@link Selector}s.
 * 
 * @author Miorel-Lucian Palii
 */
public interface Registrar {

	/**
	 * Registers this channel with this registrar's backing selector, returning
	 * a selection key. This method is equivalent to calling
	 * <code>{@linkplain #register(SelectableChannel,int,Object) register}(channel, ops, null)</code>.
	 * 
	 * @param channel
	 *            the channel to register
	 * @param ops
	 *            the interest set for the resulting key
	 * @throws ClosedChannelException
	 *             if the channel is closed
	 * @return a key representing the channel's registration
	 */
	public SelectionKey register(SelectableChannel channel, int ops) throws ClosedChannelException;

	/**
	 * Registers this channel with this registrar's backing selector, returning
	 * a selection key. This method also allows setting the interest set and
	 * attachment for the resulting selection key.
	 * 
	 * @param channel
	 *            the channel to register
	 * @param ops
	 *            the interest set for the resulting key
	 * @param attachment
	 *            the attachment for the resulting key; may be <code>null</code>
	 * @throws ClosedChannelException
	 *             if the channel is closed
	 * @return a key representing the channel's registration
	 * @see #register(SelectableChannel, int)
	 */
	public SelectionKey register(SelectableChannel channel, int ops, Object attachment) throws ClosedChannelException;

	/**
	 * Cancels the channel's registration with this registrar's backing
	 * selector.
	 * 
	 * @param channel
	 *            the channel to deregister
	 */
	public void deregister(SelectableChannel channel);
}
