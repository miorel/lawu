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
package com.googlecode.lawu.thread;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.googlecode.lawu.util.Pair;

public class ScheduledThread extends QueueThread<Pair<Long,Runnable>> {
	/**
	 * Allocates a new scheduled thread.
	 */
	public ScheduledThread() {
		super();
	}

	/**
	 * Allocates a new scheduled thread that will have the given name.
	 * 
	 * @param name
	 *            the name of the new thread
	 */
	public ScheduledThread(String name) {
		super(name);
	}

	/**
	 * Allocates a new scheduled thread that will belong to the specified thread
	 * group.
	 * 
	 * @param group
	 *            the thread group
	 */
	public ScheduledThread(ThreadGroup group) {
		super(group);
	}

	/**
	 * Allocates a new scheduled thread that will belong to the specified thread
	 * group and have the given name.
	 * 
	 * @param group
	 *            the thread group
	 * @param name
	 *            the name of the new thread
	 */
	public ScheduledThread(ThreadGroup group, String name) {
		super(group, name);
	}
	
	/**
	 * Allocates a new scheduled thread that will belong to the specified thread
	 * group and have the given name and stack size.
	 * 
	 * @param group
	 *            the thread group
	 * @param name
	 *            the name of the new thread
	 * @param stackSize
	 *            the desired stack size, or zero to ignore this parameter
	 */
	public ScheduledThread(ThreadGroup group, String name, long stackSize) {
		super(group, name, stackSize);
	}
	
	@Override
	protected void process(Pair<Long,Runnable> pair) {
		try {
			pair.getSecond().run();
		}
		catch(Throwable t) {
			report(t);
		}
	}
	
	@Override
	public void enqueue(Pair<Long,Runnable> pair) {
		if(pair == null)
			throw new IllegalArgumentException("Can't queue null task.");
		super.enqueue(pair);
	}

	public void enqueue(Runnable task, long time) {
		if(task == null)
			throw new IllegalArgumentException("Can't queue null task.");
		enqueue(new Pair<Long,Runnable>(Long.valueOf(time), task));
	}
	
	public void enqueue(long time, Runnable task) {
		enqueue(task, time);
	}
	
	@Override
	protected long getTimeBeforeProcessing(Pair<Long,Runnable> task) {
		return task.getFirst().longValue() - System.currentTimeMillis();
	}

	@Override
	protected Queue<Pair<Long,Runnable>> prepareQueue() {
		return new PriorityQueue<Pair<Long,Runnable>>(1, new Comparator<Pair<Long,Runnable>>() {
			@Override
			public int compare(Pair<Long,Runnable> a, Pair<Long,Runnable> b) {
				return a.getFirst().compareTo(b.getFirst());
			}
		});
	}
}
