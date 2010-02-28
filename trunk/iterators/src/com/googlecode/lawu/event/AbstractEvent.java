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


/**
 * Sample event interface implementation.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            type of listeners on which this event may be triggered
 */
public abstract class AbstractEvent<T extends EventListener> implements Event<T> {
	private boolean consumed = false;
	
	@Override
	public final void consume() {
		consumed = true;
	}

	@Override
	public boolean isConsumed() {
		return consumed;
	}

	@Override
	public final void trigger(T listener) {
		if(!isConsumed())
			doTrigger(listener);
	}

	/**
	 * Defines the specific trigger of this event. Implementations may assume
	 * this method will not be called on consumed events.
	 * 
	 * @param listener
	 *            listener on which to trigger
	 */
	protected abstract void doTrigger(T listener);
}
