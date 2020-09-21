package streams;

import java.util.stream.Stream;

public class StreamFromIterate {

    public static void main(String[] args) {
        
        Stream<String> strStream = Stream.iterate("a", s->s+"a");

        strStream.forEach(System.out::println);

    }
    
}
