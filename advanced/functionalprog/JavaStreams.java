import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;
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

        // 5. 
        // Stream to TreeSet
        strm = Stream.of("lion", "tiger", "zebra", "timberfox");
        TreeSet<String> set = strm
                                .filter( s -> s.startsWith("t"))
                                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);

        // 6.
        // Stream to Map 1
        Stream<String> mapStrm1 = Stream.of("lion", "tiger", "zebra", "timberfox");
        Map<String, Integer> map1 = mapStrm1
                                        .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map1);

        // 7.
        // STream to Map 2
        // Avoiding key collisions
        Stream<String> mapStrm2 = Stream.of("lion", "tiger", "zebra", "timberfox");
        Map<Integer, String> map2 = mapStrm2
                                        .collect(
                                            Collectors.toMap(
                                                String::length,
                                                s -> s, 
                                                (s1, s2) -> s1 + "-" + s2));
        System.out.println(map2);

    }
}
