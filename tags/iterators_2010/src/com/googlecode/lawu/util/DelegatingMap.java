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
package com.googlecode.lawu.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A map that delegates its map-related methods to another map. The goal is to
 * make it easier to use composition to build maps.  
 * 
 * @author Miorel-Lucian Palii
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public abstract class DelegatingMap<K, V> implements Map<K, V> {
	/**
	 * Default constructor, does nothing.
	 */
	public DelegatingMap() {
	}
	
	/**
	 * Retrieves this map's delegate.
	 * 
	 * @return the delegate
	 */
	protected abstract Map<K, V> getDelegate(); 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		getDelegate().clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsKey(Object key) {
		return getDelegate().containsKey(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsValue(Object value) {
		return getDelegate().containsValue(value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		return getDelegate().entrySet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public V get(Object key) {
		return getDelegate().get(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return getDelegate().isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<K> keySet() {
		return getDelegate().keySet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public V put(K key, V value) {
		return getDelegate().put(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		getDelegate().putAll(m);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public V remove(Object key) {
		return getDelegate().remove(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return getDelegate().size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<V> values() {
		return getDelegate().values();
	}
}
