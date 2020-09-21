package streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LazyTests {
    
    public static void main(String[] args) {
        
        final Random random = new Random();

        Supplier<Integer> s = () -> {
            Integer result = random.nextInt();
            System.out.println("Random genereated " + result );
            return result;
        };

        Stream<Integer> randomStream1 = Stream.generate(s);

        System.out.println("Test 1");

        randomStream1.filter((a) -> a >= 0 ).limit(3).forEach(System.out::println);

        System.out.println("\n\n\nTest 2");

        Stream<Integer> randomStream2 = Stream.generate(s);
        randomStream2.limit(3).filter((a) -> a >= 3).forEach(System.out::println);

    }
}
