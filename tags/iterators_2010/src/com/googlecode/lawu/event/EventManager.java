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
package com.googlecode.lawu.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps a set of event listeners and distributes events to them.
 * 
 * @author Miorel-Lucian Palii
 * @param <L>
 *            type of listeners managed
 */
public class EventManager<L extends EventListener> {
	private final List<L> listeners;

	/**
	 * Prepares a new event manager, initialized with an empty listener set.
	 */
	public EventManager() {
		this.listeners = new ArrayList<L>();
	}

	/**
	 * Adds the specified listener to this manager's listener set.
	 * 
	 * @param listener
	 *            listener to add
	 */
	public void addListener(L listener) {
		synchronized(listeners) {
			if(!listeners.contains(listener))
				listeners.add(listener);
		}
	}

	/**
	 * Removes the specified listener from this manager's listener set.
	 * 
	 * @param listener
	 *            listener to remove
	 */
	public void removeListener(L listener) {
		synchronized(listeners) {
			listeners.remove(listener);
		}
	}

	/**
	 * Distributes the given event by triggering it on all managed listeners in
	 * the order in which they were added to this manager.
	 * 
	 * @param event
	 *            event to trigger
	 */
	public void distribute(Event<L> event) {
		synchronized(listeners) {
			for(L listener: listeners)
				event.trigger(listener);
		}
	}
}
