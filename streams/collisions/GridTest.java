package streams.collisions;

import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;

import static streams.collisions.GridDetection.*;

public class GridTest {

	public static void main(String...args) {
		final int TEST_SIZE = 2_000;
		ArrayList<Box> world = CountingTest.makeRandom(TEST_SIZE);

		System.out.println("\nCounting the number of collisions:");
		
		final LongAdder  atomicCounter = new LongAdder();
		Consumer<Collision> action = c -> atomicCounter.increment();

		
		System.out.println("\nSingle phase, parallel stream");
		// Warm up
		BasicDetection.forEachCollision3(world, action);
		atomicCounter.reset();
		// Timed run
		Time.timeIt(() -> BasicDetection.forEachCollision3(world, action));
		System.out.println("# of collisions: " + atomicCounter);

		
		System.out.println("\nTwo phases, with duplicates");
		// Warm up
		forEachCollision4(world, action);
		atomicCounter.reset();
		// Timed run
		Time.timeIt(() -> forEachCollision4(world, action));
		System.out.println("# of collisions: " + atomicCounter);
		
		
		System.out.println("\nTwo phases, collision stream + count");
		// Warm up
		long tempCounter = collisionStream(world).count();
		// Timed run
		Time.timeIt(() -> collisionStream(world).count());
		System.out.println("# of collisions: " + tempCounter);
	}
}
