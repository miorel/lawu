package lawu.util.iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Miorel-Lucian Palii
 */
public class NodeListIterator extends AbstractUniversalIterator<Node> {
	private final NodeList list;
	private int pointer;

	/**
	 * @param list
	 */
	public NodeListIterator(NodeList list) {
		this.list = list;
		reset();
	}

	public void advance() {
		++this.pointer;
	}

	public Node current() {
		return this.list.item(this.pointer);
	}

	public boolean isDone() {
		return this.pointer >= this.list.getLength();
	}

	public void reset() {
		this.pointer = 0;
	}
}
