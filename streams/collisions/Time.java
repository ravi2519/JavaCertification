package streams.collisions;

import java.util.function.Function;
import java.util.function.Supplier;

public class Time {
	public static void timeIt(Runnable r) {
		timeIt(() -> { r.run(); return 0;});
	}

	public static <S,T> T timeIt(Function<S,T> fun, S arg) {
		long start = System.nanoTime();
		T result = fun.apply(arg);
		long stop = System.nanoTime();
		System.out.println("Time: " + (stop-start)/1000000.0 + " msec");
		return result;
	}

	public static <T> T timeIt(Supplier<T> s) {
		return timeIt(obj -> s.get(), null);
	}
}
