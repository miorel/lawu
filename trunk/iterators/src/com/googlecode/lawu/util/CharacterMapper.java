package com.googlecode.lawu.util;

import java.util.HashMap;
import java.util.Map;

public class CharacterMapper<T> implements Mapper<T,Character> {
	private final Map<T,Character> map;
	private char max = Character.MIN_VALUE;
	
	public CharacterMapper() {
		this.map = new HashMap<T,Character>();
	}

	@Override
	public Character map(T element) {
		Character ret;
		if(element == null)
			ret = Character.valueOf(Character.MIN_VALUE);
		else
			synchronized(map) {
				ret = map.get(element);
				if(ret == null) {
					if(max == Character.MAX_VALUE)
						throw new Error("Including this element will break the mapper's one-to-one requirement.");
					ret = Character.valueOf(++max);
					map.put(element, ret);
				}
			}
		return ret;
	}
}
