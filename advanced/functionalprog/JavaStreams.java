import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    
    public static void main(String[] args) {
        
        // 1.
        // Streams are lazily evaluated
        var cats = new ArrayList<String>();
        cats.add("Annie");
        cats.add("Ripely");
        var str = cats.stream();
        cats.add("KC");
        System.out.println(str.count()); // 3

        // 2.
        Stream<Integer> intStr = Stream.of(100,1,231,3333,221,423);
        intStr
            .findAny()
            .map(n -> "" + n)
            .filter(n -> n.length() == 3 )
            .ifPresent(System.out::println);

        // 3. 
        // Collectors.joining
        var strm = Stream.of("lion", "tiger", "zebra");
        String j = strm.collect(Collectors.joining("/"));
        System.out.println(j); // lion/tiger/zebra

        // 4.
        // 
        // Collectors.averagingDouble(mapper)
        strm = Stream.of("lion", "tiger", "zebra");
        Double avg = strm.collect(Collectors.averagingDouble(String::length));
        System.out.println(avg);
    }
}
