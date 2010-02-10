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
package com.googlecode.lawu.util.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

/**
 * Utility event handler class that provides empty implementations for all of
 * its event-handling methods.
 * 
 * @author Miorel-Lucian Palii
 */
public abstract class EventAdapter implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener, WindowListener, WindowFocusListener {
	/**
	 * Default constructor, does nothing special.
	 */
	public EventAdapter() {
	}
	
	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseDragged(MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseMoved(MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseWheelMoved(MouseWheelEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowActivated(WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowClosed(WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowClosing(WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowDeactivated(WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowDeiconified(WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowIconified(WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowOpened(WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowGainedFocus(WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowLostFocus(WindowEvent e) {
	}
}
