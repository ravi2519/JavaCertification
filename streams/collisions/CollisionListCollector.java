package streams.collisions;

import java.util.*;
import java.util.stream.Collector;

/** A non-concurrent collector for a stream of Boxes,
 * 	returning a list of collisions (with potential duplicates). 
 * 
 *  @author Marco Faella
 *  @version 1.0
 */
public class CollisionListCollector {
	private ArrayList<Box> cache = new ArrayList<>();
	private List<Collision> result = new ArrayList<>();
	
	public void update(Box b) {
		for (Box a: cache)
			if (Box.areOverlapping(a, b))
				result.add(new Collision(a, b));
		cache.add(b);
	}
	
	public CollisionListCollector merge(CollisionListCollector other) {
		result.addAll(other.result);
		for (Box a: cache)
			for (Box b: other.cache)
				if (Box.areOverlapping(a, b))
					result.add(new Collision(a, b));
		cache.addAll(other.cache);
		return this;
	}
	
	public List<Collision> finish() {
		return result;
	}
	
	public static Collector<Box, ?, List<Collision>> make() {
		return Collector.<Box, CollisionListCollector, List<Collision>>of(
				CollisionListCollector::new,
				CollisionListCollector::update,
				CollisionListCollector::merge,
				CollisionListCollector::finish,
				Collector.Characteristics.UNORDERED);
	}
}
