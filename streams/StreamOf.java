package streams;

import java.util.stream.Stream;

public class StreamOf {
    
    public static void main(String[] args) {
     
        Stream<String> strStream = Stream.of( "One", "Two", "Three");
        strStream.forEach(System.out::println);

        Stream<Integer> intStream = Stream.of(1,2,2,3,4,3);
        intStream.distinct().forEach(System.out::println);

    }

}
