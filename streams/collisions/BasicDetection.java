package streams.collisions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class BasicDetection {
	
	public static void forEachCollision1(Collection<Box> c, 
			                            Consumer<Collision> collisionHandler) {
		// for every pair (a,b) of boxes...
		for (Box a: c)
			for (Box b: c)
				// ...check if they are colliding
				if (Box.areOverlapping(a, b))
					collisionHandler.accept(new Collision(a,b));
	}

	
	public static void forEachCollision2(ArrayList<Box> l, 
			                             Consumer<Collision> collisionHandler) {
		// for every pair (a,b) of boxes, with a coming before b in the list 
		for (int i=0; i<l.size(); i++)
			for (int j=i+1; j<l.size(); j++) {
				Box a = l.get(i),
					b = l.get(j);
				if (Box.areOverlapping(a, b))
					collisionHandler.accept(new Collision(a,b));
			}
	}

	/* Using a parallel stream */
	public static void forEachCollision3(Collection<Box> c, 
			                             Consumer<Collision> collisionHandler) {
		c.parallelStream().collect(() -> new ForEachCollisionCollector(collisionHandler),
				                   ForEachCollisionCollector::update,
				                   ForEachCollisionCollector::merge);
	}
}
