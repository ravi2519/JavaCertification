package streams;

import java.util.stream.Stream;

public class StreamChainedOperations {

    public static void main(String[] args) {

        // Everything is valid here
        int sum = Stream.of(-1, -2).filter(i -> i > 0) // Line 1
                .map(i -> 0 - i) // Line 2
                .mapToInt(i -> i) // Line 3
                .sum();
        System.out.println(sum);
    
    }
}
