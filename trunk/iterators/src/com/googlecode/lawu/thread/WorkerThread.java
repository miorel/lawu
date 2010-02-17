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

import java.util.LinkedList;
import java.util.Queue;

/**
 * A thread that runs tasks from a queue, in order.
 * 
 * @author Miorel-Lucian Palii
 */
public class WorkerThread extends SpecializedThread {	
	private final Queue<Runnable> taskQueue = new LinkedList<Runnable>();

	/**
	 * Allocates a new worker thread.
	 */
	public WorkerThread() {
		super();
	}

	/**
	 * Allocates a new worker thread that will have the given name.
	 * 
	 * @param name
	 *            the name of the new thread
	 */
	public WorkerThread(String name) {
		super(name);
	}

	/**
	 * Allocates a new worker thread that will belong to the specified thread
	 * group.
	 * 
	 * @param group
	 *            the thread group
	 */
	public WorkerThread(ThreadGroup group) {
		super(group);
	}

	/**
	 * Allocates a new worker thread that will belong to the specified thread
	 * group and have the given name.
	 * 
	 * @param group
	 *            the thread group
	 * @param name
	 *            the name of the new thread
	 */
	public WorkerThread(ThreadGroup group, String name) {
		super(group, name);
	}
	
	/**
	 * Allocates a new worker thread that will belong to the specified thread
	 * group and have the given name and stack size.
	 * 
	 * @param group
	 *            the thread group
	 * @param name
	 *            the name of the new thread
	 * @param stackSize
	 *            the desired stack size, or zero to ignore this parameter
	 */
	public WorkerThread(ThreadGroup group, String name, long stackSize) {
		super(group, name, stackSize);
	}

	/**
	 * Executes a task from the queue (unless interrupted while waiting for a
	 * task to be queued).
	 */
	@Override
	protected void work() {
		Runnable task = null; 
		synchronized(taskQueue) {
			boolean runTask = true; // without this variable, the thread would run one more task after being interrupted
			if(interrupted()) {
				runTask = false;
				interrupt();
			}
			else 
				while(taskQueue.isEmpty())
					try {
						taskQueue.wait(); // I'll wake when a task is queued
					}
					catch(InterruptedException e) {
						runTask = false;
						interrupt();
						break;
					}
			if(runTask)
				task = taskQueue.poll();
		}
		if(task != null) 
			try {
				task.run();
			}
			catch(Throwable t) {
				report(t);
			}
	}
	
	/**
	 * Empties the task queue so that remaining task objects can be garbage
	 * collected.
	 */
	@Override
	protected void cleanUp() {
		clearTasks();	
	}

	/**
	 * Adds a task to this worker thread's queue.
	 * 
	 * @param task
	 *            the task to queue
	 */
	public void queueTask(Runnable task) {
		if(task == null)
			throw new NullPointerException("Can't queue null task.");
		synchronized(taskQueue) {
			taskQueue.add(task);
			taskQueue.notify(); // this thread is the only one that might be wait()-ing
		}
	}
	
	/**
	 * Empties this worker thread's task queue.
	 */
	public void clearTasks() {
		synchronized(taskQueue) {
			taskQueue.clear();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void interrupt() {
		synchronized(taskQueue) {
			super.interrupt();
		}
	}
}
