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
import java.nio.channels.SelectionKey;
import java.nio.channels.spi.SelectorProvider;

import com.googlecode.lawu.nio.SelectingThread;

/**
 * A selector-backed thread for managing channel clients.
 * 
 * @author Miorel-Lucian Palii
 */
public abstract class ClientsThread extends SelectingThread {

	/**
	 * Allocates a new clients thread. The thread will use the system-wide
	 * default selector provider.
	 * 
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread() throws IOException {
		super();
	}

	/**
	 * Allocates a new clients thread that will have the given name. The
	 * thread will use the system-wide default selector provider.
	 * 
	 * @param name
	 *            the name of the new thread
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread(String name) throws IOException {
		super(name);
	}

	/**
	 * Allocates a new clients thread that will belong to the specified thread
	 * group. The thread will use the system-wide default selector provider.
	 * 
	 * @param group
	 *            the thread group
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread(ThreadGroup group) throws IOException {
		super(group);
	}

	/**
	 * Allocates a new clients thread that will belong to the specified thread
	 * group and have the given name. The thread will use the system-wide
	 * default selector provider.
	 * 
	 * @param group
	 *            the thread group
	 * @param name
	 *            the name of the new thread
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread(ThreadGroup group, String name) throws IOException {
		super(group, name);
	}
	
	/**
	 * Allocates a new clients thread that will belong to the specified thread
	 * group and have the given name and stack size. The thread will use the
	 * system-wide default selector provider.
	 * 
	 * @param group
	 *            the thread group
	 * @param name
	 *            the name of the new thread
	 * @param stackSize
	 *            the desired stack size, or zero to ignore this parameter
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread(ThreadGroup group, String name, long stackSize) throws IOException {
		super(group, name, stackSize);
	}

	/**
	 * Allocates a new clients thread that will use the specified selector
	 * provider.
	 * 
	 * @param provider
	 *            the selector provider to use, or null to use the system-wide
	 *            default
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread(SelectorProvider provider) throws IOException {
		super(provider);
	}

	/**
	 * Allocates a new clients thread that will use the specified selector
	 * provider and have the given name.
	 * 
	 * @param provider
	 *            the selector provider to use, or null to use the system-wide
	 *            default
	 * @param name
	 *            the name of the new thread
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread(SelectorProvider provider, String name) throws IOException {
		super(provider, name);
	}

	/**
	 * Allocates a new clients thread that will use the specified selector
	 * provider and belong to the specified thread group.
	 * 
	 * @param provider
	 *            the selector provider to use, or null to use the system-wide
	 *            default
	 * @param group
	 *            the thread group
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread(SelectorProvider provider, ThreadGroup group) throws IOException {
		super(provider, group);
	}

	/**
	 * Allocates a new clients thread that will use the specified selector
	 * provider, belong to the specified thread group, and have the given name.
	 * 
	 * @param provider
	 *            the selector provider to use, or null to use the system-wide
	 *            default
	 * @param group
	 *            the thread group
	 * @param name
	 *            the name of the new thread
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread(SelectorProvider provider, ThreadGroup group, String name) throws IOException {
		super(provider, group, name);
	}

	/**
	 * Allocates a new clients thread that will use the specified selector
	 * provider, belong to the specified thread group, and have the given name
	 * and stack size.
	 * 
	 * @param provider
	 *            the selector provider to use, or <code>null</code> to use the
	 *            system-wide default
	 * @param group
	 *            the thread group
	 * @param name
	 *            the name of the new thread
	 * @param stackSize
	 *            the desired stack size, or zero to ignore this parameter
	 * @throws IOException
	 *             if the selector provider propagates an I/O error during the
	 *             open operation
	 */
	public ClientsThread(SelectorProvider provider, ThreadGroup group, String name, long stackSize) throws IOException {
		super(provider, group, name, stackSize);
	}

	/**
	 * Tells the client attached to the given key to finish connecting.
	 * 
	 * @param key
	 *            the key to handle
	 */
	@Override
	protected void connect(SelectionKey key) {
		Client client = (Client) key.attachment(); 
		try {
			client.connect();
		}
		catch(IOException e) {
			report(e);
			client.disconnect();
		}
	}
	
	/**
	 * Tells the client attached to the given key to read from its channel.
	 * 
	 * @param key
	 *            the key to handle
	 */
	protected void read(SelectionKey key) {
		Client client = (Client) key.attachment(); 
		try {
			client.read();
		}
		catch(IOException e) {
			report(e);
			client.disconnect();
		}
	}
	
	/**
	 * Tells the client attached to the given key to write to its channel.
	 * 
	 * @param key
	 *            the key to handle
	 */
	@Override
	protected void write(SelectionKey key) {
		Client client = (Client) key.attachment(); 
		try {
			client.write();
		}
		catch(IOException e) {
			report(e);
			client.disconnect();
		}
	}
}
