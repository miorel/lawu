package lawu.util.event;

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
public abstract class EventAdapter implements KeyListener, MouseListener,
		MouseMotionListener, MouseWheelListener, WindowListener,
		WindowFocusListener {

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void keyPressed(@SuppressWarnings("unused") KeyEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void keyReleased(@SuppressWarnings("unused") KeyEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void keyTyped(@SuppressWarnings("unused") KeyEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseClicked(@SuppressWarnings("unused") MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseEntered(@SuppressWarnings("unused") MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseExited(@SuppressWarnings("unused") MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mousePressed(@SuppressWarnings("unused") MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseReleased(@SuppressWarnings("unused") MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseDragged(@SuppressWarnings("unused") MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseMoved(@SuppressWarnings("unused") MouseEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void mouseWheelMoved(@SuppressWarnings("unused") MouseWheelEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowActivated(@SuppressWarnings("unused") WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowClosed(@SuppressWarnings("unused") WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowClosing(@SuppressWarnings("unused") WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowDeactivated(@SuppressWarnings("unused") WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowDeiconified(@SuppressWarnings("unused") WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowIconified(@SuppressWarnings("unused") WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowOpened(@SuppressWarnings("unused") WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowGainedFocus(@SuppressWarnings("unused") WindowEvent e) {
	}

	/**
	 * Ignores the event.
	 * 
	 * @param e the event
	 */
	public void windowLostFocus(@SuppressWarnings("unused") WindowEvent e) {
	}
}