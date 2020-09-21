package streams;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 
 * Filter 10 random positive integers
 * 
 */
public class StreamFIlter1 {

    public static void main(String[] args) {

        // Using 'filter'

        final Random rand = new Random();
        Stream<Integer> randoms = Stream.generate(rand::nextInt);

        randoms.filter(a -> a > 0)
            .distinct()
            .limit(10)
            .forEach(System.out::println);

        
        // Using Takewhile
        

    }
    
}
