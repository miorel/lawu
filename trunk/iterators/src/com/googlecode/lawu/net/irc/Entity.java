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
package com.googlecode.lawu.net.irc;

import java.net.InetSocketAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Entity {
	private static final Pattern ENTITY_INFO_FIELD; 
	private static final Pattern ENTITY_INFO;
	
	static {
		String eifr = "[^!@]+";
		ENTITY_INFO_FIELD = Pattern.compile(eifr);
		ENTITY_INFO = Pattern.compile(String.format("(?:(%1$s)!)?(?:(%1$s)@)?(%1$s)", eifr));	
	}
	
	private final InetSocketAddress address;
	private final String nick;
	private final String ident;
	private final String host;

	public Entity(String nick, String ident, String host, InetSocketAddress address) {
		if(nick != null) {
			if(nick.isEmpty())
				throw new IllegalArgumentException("The nickname may not be zero-length, use null instead.");
			else if(!ENTITY_INFO_FIELD.matcher(nick).matches())
				throw new IllegalArgumentException("The nickname must be a valid entity info field.");
		}
		if(ident != null) {
			if(ident.isEmpty())
				throw new IllegalArgumentException("The ident may not be zero-length, use null instead.");
			else if(!ENTITY_INFO_FIELD.matcher(ident).matches())
				throw new IllegalArgumentException("The ident must be a valid entity info field.");
		}
		if(host == null || host.isEmpty())
			throw new IllegalArgumentException("The host may not be zero-length.");
		if(!ENTITY_INFO_FIELD.matcher(host).matches())
			throw new IllegalArgumentException("The host must be a valid entity info field.");
		if(address != null && address.getAddress().isAnyLocalAddress())
			throw new IllegalArgumentException("The address may not be a wildcard, use null instead.");
		this.nick = nick;
		this.ident = ident;
		this.host = host;
		this.address = address;
	}
	
	public static Entity forInfo(String entityInfo, InetSocketAddress address) {
		if(entityInfo == null)
			throw new IllegalArgumentException("Can't parse null string.");
		Matcher m = ENTITY_INFO.matcher(entityInfo);
		if(!m.matches())
			throw new IllegalArgumentException("Improperly formatted info string.");
		return new Entity(m.group(1), m.group(2), m.group(3), address);
	}

	public static Entity forInfo(String entityInfo) {
		return forInfo(entityInfo, null);
	}
	
	public InetSocketAddress getAddress() {
		return address;
	}
	
	public String getNick() {
		return nick;
	}

	public String getIdent() {
		return ident;
	}

	public String getHost() {
		return host;
	}

	public boolean isUser() {
		return nick != null && ident != null;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Entity) {
			Entity e = (Entity) o;
			ret = (this.address == null ? e.address == null : this.address.equals(e.address))
				&& (this.nick == null ? e.nick == null : this.nick.equals(e.nick))
				&& (this.ident == null ? e.ident == null : this.ident.equals(e.ident))
				&& this.host.equals(e.host);
		}
		return ret;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(nick != null)
			sb.append(nick).append('!');
		if(ident != null)
			sb.append(ident).append('@');
		sb.append(host);
		if(address != null)
			sb.append(" on ").append(address);
		return sb.toString();
	}
}
