package streams.collisions;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Detection algorithms using a grid-based broad phase.
 * 
 * @author Marco Faella
 * @version 1.0
 */
public class GridDetection {

	public static final GridSpec gridSpec = new GridSpec();
	static {
		// size of the grid
		gridSpec.rows = 4;
		gridSpec.cols = 6;
		gridSpec.rowHeight = CountingTest.YRES / gridSpec.rows;
		gridSpec.colWidth  = CountingTest.XRES / gridSpec.cols;
	}

	
	public static List<List<Box>> broadPhase(Collection<Box> c, GridSpec gridSpec) {
		return c.parallelStream().collect(GridCollector.of(gridSpec));
	}

	
	/** 
	 * Builds the set of all collisions.
	 * Based on broad phase / narrow phase.
	 * Duplicate removal is performed by the final "toSet" collector.
	 * 
	 * @param c		the collection of boxes to be checked for collisions 
	 * @return 		the set of all collisions
	 */
	public static Set<Collision> allCollisions(Collection<Box> c) {
		// Broad phase
		List<List<Box>> gridCells = broadPhase(c, GridDetection.gridSpec);
		// Narrow phase
		return gridCells.stream() // stream of List<Box>
		                .flatMap(
		                		      (List<Box> l) -> l.stream()
		                		                        .collect(CollisionListCollector.make()) // List<Collision>
		                		                        .stream()                               // stream of collisions
		                		    ) // stream of collisions
		                .collect(Collectors.toSet()); // duplicates are automatically removed
	}
	
	
	
	public static Set<Collision> allCollisionsAlt(Collection<Box> c) {
		// Broad phase
		List<List<Box>> gridCells = GridDetection.broadPhase(c, GridDetection.gridSpec);
		// Narrow phase
		return gridCells.parallelStream() // parallel!
		                .flatMap(
		                		      (List<Box> l) -> l.parallelStream() // parallel!
		                		                        .collect(CollisionListCollector.make())
		                		                        .stream()
		                		    )
		                .collect(Collectors.toSet());
	}

	
	/** 
	 * Builds the stream of all collisions from a given set of boxes.
	 * Based on broad phase / narrow phase.
	 * Duplicate removal is performed by the final "distinct" operation.
	 * 
	 * @param c		the collection of boxes to be checked for collisions 
	 * @return 		the stream of all collisions
	 */
	public static Stream<Collision> collisionStream(Collection<Box> c) {
		return broadPhase(c, gridSpec).stream() // a stream of List<Box>
				.flatMap(
						  l -> l.stream()       // a stream of Box
						        .collect(CollisionListCollector.make())
						        .stream()       // a stream of Collision
						)
				.unordered()
				.distinct();				
	}
	
	
	
	
	
	
	
	
	/** 
	 * Executes the handler at least once on each collision.
	 * Based on broad phase / narrow phase.
	 * 
	 * @param c					the collection of boxes to be checked for collisions 
	 * @param collisionHandler	the handler to be executed for each collision
	 */
	public static void forEachCollision4(Collection<Box> c, 
			                             Consumer<Collision> collisionHandler) {				
		// Broad phase
		List<List<Box>> gridCells = broadPhase(c, gridSpec);
		// Narrow phase
		gridCells.parallelStream()
		         .forEach(l -> BasicDetection.forEachCollision3(l, collisionHandler));
	}
	
	
	
	
	
	
	
	
	
	
	public static Stream<Collision> collisionStreamFunc(Collection<Box> c) {
		return broadPhase(c, gridSpec).stream() // a stream of List<Box>
				.flatMap(
						  l -> l.stream()       // a stream of Box
						        .reduce(new CollisionListFunctionalCollector(),
						        		CollisionListFunctionalCollector::accumulate,
						        		CollisionListFunctionalCollector::combine
						        	)
						        .finish().stream()       // a stream of Collision
						)
				.unordered()
				.distinct();				
	}

	
	
	/** 
	 * Builds the set of all collisions.
	 * Based on broad phase / narrow phase.
	 * 
	 * @param c		the collection of boxes to be checked for collisions 
	 * @return 		the set of all collisions
	 */
	public static Set<Collision> allCollisionsAlt2(Collection<Box> c) {
		// Broad phase
		List<List<Box>> gridCells = GridDetection.broadPhase(c, GridDetection.gridSpec);
		// Narrow phase
		return gridCells.stream()
		                .map(l -> l.stream().collect(CollisionSetCollector.make()))
				        .reduce(new HashSet<>(), (a,b) -> { a.addAll(b); return a; } );
	}

}
