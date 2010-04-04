package com.googlecode.lawu.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps objects onto characters. Used as default mapper by
 * {@link CharSequenceList}.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            the type of objects to map
 */
public class CharacterMapper<T> implements Mapper<T,Character> {
	private final Map<T,Character> map;
	
	private char max = Character.MIN_VALUE;
	
	/**
	 * Constructs a new character mapper.
	 */
	public CharacterMapper() {
		this.map = new HashMap<T,Character>();
	}

	@Override
	public Character map(T element) {
		Character ret;
		if(element == null)
			ret = Character.valueOf(Character.MIN_VALUE);
		else
			synchronized(this.map) {
				ret = this.map.get(element);
				if(ret == null) {
					if(this.max == Character.MAX_VALUE)
						throw new Error("Including this element will break the mapper's one-to-one requirement.");
					ret = Character.valueOf(++this.max);
					this.map.put(element, ret);
				}
			}
		return ret;
	}
}
