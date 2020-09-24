package streams;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamFindAnyAndFilter {

    public static void main(String[] args) {
        
        //
        // Exception in thread "main" java.util.NoSuchElementException: No value present
        //
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Optional optional = stream.findAny().filter(i -> { System.out.println(i); return i % 2 == 0; } );
        System.out.println(optional.get());

    }
    
}
