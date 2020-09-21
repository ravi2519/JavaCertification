package streams.collisions;

import java.util.*;
import java.util.stream.Collectors;

import static streams.collisions.GridDetection.*;

public class AllCollisionsTest {
	
	public static void main(String[] args) {
		final int TEST_SIZE = 5_000;
		ArrayList<Box> world = CountingTest.makeRandom(TEST_SIZE);
		
		
		System.out.println("\nBuilding the set of all collisions:");
		
		// 1 Reference
		System.out.println("\nSingle phase sequential"); // just two nested loops
		final Set<Collision> collisions = new HashSet<>();
		// Warm up
		BasicDetection.forEachCollision2(world, coll -> collisions.add(coll));
		collisions.clear();
		// Timed run
		Time.timeIt(() -> {
			BasicDetection.forEachCollision2(
					world, coll -> collisions.add(coll));
		});
	
		
		// 2
		System.out.println("\nTwo phases; first parallel, second seq.");
		// Warm up
		Set<Collision> temp = allCollisions(world);
		// Timed run
		Time.timeIt(() -> {
			Set<Collision> coll = allCollisions(world);
		});

		
		// 3
		System.out.println("\nTwo phases; all parallel");
		// Warm up
		Set<Collision> temp2 = allCollisionsAlt(world);
		// Timed run
		Time.timeIt(() -> {
			Set<Collision> coll = allCollisionsAlt(world);
		});

		
		// 4
		System.out.println("\nTwo phases; collision stream");
		// Warm up
		Set<Collision> tempcoll = collisionStream(world).collect(Collectors.toSet());
		// Timed run
		Time.timeIt(() -> {
			Set<Collision> coll = collisionStream(world).collect(Collectors.toSet());
		});
	}

}
