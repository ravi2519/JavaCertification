package streams;

import java.util.stream.Stream;

public class StreamTraversedOnce {
    
    public static void main(String[] args) {
        
        Stream<Integer> intStream = Stream.of(1,2,3,4);

        intStream.forEach(System.out::println);

        // trying to traverse the stream again causes
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        intStream.forEach(System.out::println);

        Stream<Integer> newIntStream = Stream.of(1,2,3,4);
        newIntStream.limit(2);
        
        // trying to traverse the stream again causes
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        newIntStream.forEach(System.out::println);


    }

}
