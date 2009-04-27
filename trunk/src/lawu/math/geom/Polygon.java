package lawu.math.geom;

import lawu.math.Vector;
import lawu.util.iterator.UniversalIterator;

/**
 * @author Miorel-Lucian Palii
 *
 */
public interface Polygon {
	/**
	 * @return
	 */
	public int getVertexCount();

	/**
	 * @return
	 */
	public UniversalIterator<Vector> getVertices();
}
