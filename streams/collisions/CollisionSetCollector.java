package streams.collisions;

import java.util.*;
import java.util.stream.Collector;

/** A non-concurrent collector for a stream of Boxes,
 * 	returning a set of collisions. 
 * 
 *  @author M. Faella
 */
public class CollisionSetCollector {
	private ArrayList<Box> cache = new ArrayList<>();
	private Set<Collision> result = new HashSet<>();
	
	public void update(Box b) {
		for (Box a: cache)
			if (Box.areOverlapping(a, b))
				result.add(new Collision(a, b));
		cache.add(b);
	}
	
	public CollisionSetCollector merge(CollisionSetCollector other) {
		result.addAll(other.result);
		for (Box a: cache)
			for (Box b: other.cache)
				if (Box.areOverlapping(a, b))
					result.add(new Collision(a, b));
		cache.addAll(other.cache);
		return this;
	}
	
	public Set<Collision> finish() {
		return result;
	}
	
	public static Collector<Box, ?, Set<Collision>> make() {
		return Collector.<Box, CollisionSetCollector, Set<Collision>>of(
				CollisionSetCollector::new,
				CollisionSetCollector::update,
				CollisionSetCollector::merge,
				CollisionSetCollector::finish,
				Collector.Characteristics.UNORDERED);
	}
}
