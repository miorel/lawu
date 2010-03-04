package com.googlecode.lawu.util;

import java.util.List;

public class CharSequenceList<T> implements CharSequence {
	private final Mapper<T,Character> mapper;
	private final List<T> list;
	
	public CharSequenceList(Mapper<T,Character> mapper, List<T> list) {
		if(mapper == null)
			throw new IllegalArgumentException("The mapper may not be null.");
		if(list == null)
			throw new IllegalArgumentException("The list may not be null.");
		this.mapper = mapper;
		this.list = list;
	}	
	
	@Override
	public char charAt(int index) {
		return mapper.map(list.get(index)).charValue();
	}

	@Override
	public int length() {
		return list.size();
	}

	@Override
	public CharSequenceList<T> subSequence(int start, int end) {
		return new CharSequenceList<T>(mapper, list.subList(start, end));
	}
}
