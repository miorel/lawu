package com.googlecode.lawu.util;

import java.util.List;

public class CharSequenceList<T> implements CharSequence {
	private final Mapper<T,Character> mapper;
	private final List<T> list;
	private final int start;
	private final int end;
	
	public CharSequenceList(Mapper<T,Character> mapper, List<T> list) {
		this(mapper, list, 0, list.size());
	}
	
	public CharSequenceList(Mapper<T,Character> mapper, List<T> list, int start, int end) {
		if(mapper == null)
			throw new IllegalArgumentException("The mapper may not be null.");
		if(list == null)
			throw new IllegalArgumentException("The list may not be null.");
		if(start < 0 || start >= list.size())
			throw new IllegalArgumentException("The start index must be within the bounds of the list.");
		if(end < start)
			throw new IllegalArgumentException("The end index may not be less than the start index.");
		if(end > list.size())
			throw new IllegalArgumentException("The end index may not exceed the size of the list.");
		this.mapper = mapper;
		this.list = list;
		this.start = start;
		this.end = end;
	}	
	
	@Override
	public char charAt(int index) {
		return mapper.map(list.get(start + index)).charValue();
	}

	@Override
	public int length() {
		return end - start;
	}

	@Override
	public CharSequenceList<T> subSequence(int start, int end) {
		return new CharSequenceList<T>(mapper, list, this.start + start, this.start + end);
	}
}
