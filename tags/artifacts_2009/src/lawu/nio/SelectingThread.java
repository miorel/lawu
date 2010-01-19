/*
 * lawu
 * Copyright (C) 2009 Miorel-Lucian Palii
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
package lawu.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

public abstract class SelectingThread extends Thread {
	private Selector selector;
	
	protected SelectingThread() {
	}
	
	protected void prepareSelector() {
		if(this.selector == null)
			try {
				this.selector = Selector.open();
			}
			catch(IOException e) {
				throw new RuntimeException(e);
			}
	}
	
	protected Selector getSelector() {
		return this.selector;
	}
	
	protected void init() {
		prepareSelector();
	}
	
	protected void select() throws IOException {
		synchronized(this.selector) {
			this.selector.select();
		}
	}
	
	@Override
	public void run() {
		init();
		
		while(!Thread.interrupted()) {
			try {
				select();
			}
			catch(IOException e) {
				throw new RuntimeException(e);
			}
			
			Set<SelectionKey> keys = getSelector().selectedKeys();
			for(SelectionKey key: keys)
				handleKey(key);
			keys.clear();
		}
	}
	
	protected abstract void handleKey(SelectionKey key);
}
