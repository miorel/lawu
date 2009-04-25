package lawu.util.iterator;

import lawu.dp.Iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListIterator implements Iterator<Node> {
	private final NodeList list;
	private int pointer;

	public NodeListIterator(NodeList list) {
		this.list = list;
	}

	public void advance() {
		++pointer;
	}

	public Node current() {
		return list.item(pointer);
	}

	public boolean isDone() {
		return pointer >= list.getLength();
	}

	public void reset() {
		pointer = 0;
	}
}
