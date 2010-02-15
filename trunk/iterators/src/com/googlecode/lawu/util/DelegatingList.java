package com.googlecode.lawu.util;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import com.googlecode.lawu.util.iterators.ReversibleIterator;

public abstract class DelegatingList<T> implements List<T> {
	public DelegatingList() {
	}
	
	protected abstract List<T> getDelegate();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(T e) {
		return getDelegate().add(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(int index, T element) {
		getDelegate().add(index, element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(Collection<? extends T> c) {
		return getDelegate().addAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return getDelegate().addAll(index, c);
	}

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
	public boolean contains(Object o) {
		return getDelegate().contains(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return getDelegate().containsAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T get(int index) {
		return getDelegate().get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int indexOf(Object o) {
		return getDelegate().indexOf(o);
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
	public ReversibleIterator<T> iterator() {
		return Iterators.iterator(getDelegate());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int lastIndexOf(Object o) {
		return getDelegate().lastIndexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<T> listIterator() {
		return getDelegate().listIterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<T> listIterator(int index) {
		return getDelegate().listIterator(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Object o) {
		return getDelegate().remove(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T remove(int index) {
		return getDelegate().remove(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return getDelegate().removeAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return getDelegate().retainAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T set(int index, T element) {
		return getDelegate().set(index, element);
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
	public List<T> subList(int fromIndex, int toIndex) {
		return getDelegate().subList(fromIndex, toIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() {
		return getDelegate().toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("hiding")
	public <T> T[] toArray(T[] a) {
		return getDelegate().toArray(a);
	}
}
