package com.googlecode.lawu.util;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Interprets a {@link List} as a {@link CharSequence}. This allows
 * {@linkplain Pattern pattern matching} on lists.
 * 
 * @author Miorel-Lucian Palii
 * @param <T>
 *            the type of elements in the list
 * @see CharacterMapper
 * @see CharSequence
 * @see Pattern
 */
public class CharSequenceList<T> implements CharSequence {
	private final Mapper<T,Character> mapper;
	private final List<T> list;

	/**
	 * Constructs a <code>CharSequence</code> view of the list using the
	 * specified mapper.
	 * 
	 * @param mapper
	 *            the mapper to use; may be <code>null</code> to use a default
	 *            mapper
	 * @param list
	 *            the list to wrap
	 */
	public CharSequenceList(Mapper<T,Character> mapper, List<T> list) {
		if(list == null)
			throw new NullPointerException("The list may not be null.");
		if(mapper == null)
			mapper = new CharacterMapper<T>();
		this.mapper = mapper;
		this.list = list;
	}

	/**
	 * Constructs a <code>CharSequence</code> view of the list using a default
	 * mapper.
	 * 
	 * @param list
	 *            the list to wrap
	 */
	public CharSequenceList(List<T> list) {
		this(null, list);
	}
	
	@Override
	public char charAt(int index) {
		return this.mapper.map(this.list.get(index)).charValue();
	}

	@Override
	public int length() {
		return this.list.size();
	}

	@Override
	public CharSequenceList<T> subSequence(int start, int end) {
		return new CharSequenceList<T>(this.mapper, this.list.subList(start, end));
	}
}
