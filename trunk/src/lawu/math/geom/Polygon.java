package lawu.math.geom;

import lawu.math.Vector;
import lawu.util.iterator.UniversalIterator;

/**
 * @author Miorel-Lucian Palii
 *
 */
public interface Polygon {
	/**
	 * Returns the number of vertices of this polygon.
	 * 
	 * @return the number of vertices
	 */
	public int getVertexCount();

	/**
	 * Retrieves an iterator over this polygon's vertices.
	 * 
	 * @return an iterator over the vertices
	 */
	public UniversalIterator<Vector> getVertices();
}
