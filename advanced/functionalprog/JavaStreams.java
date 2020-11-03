import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.function.Predicate;
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
            .ifPresent(System.out::println); // 100

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

        // 8.
        // Stream to Map 3
        // Return a TreeMap instead
        Stream<String> mapStrm3 = Stream.of("lion", "tiger", "zebra", "timberfox");
        TreeMap<Integer, String> map3 = mapStrm3
                                        .collect(
                                            Collectors.toMap(
                                                String::length,
                                                s -> s, 
                                                (s1, s2) -> s1 + "-" + s2,
                                                TreeMap::new));
        System.out.println(map3);

        // 9.
        // Stream to Map 4
        // groupingBy
        Stream<String> mapStrm4 = Stream.of("lion", "tiger", "zebra", "timberfox");
        Map<Integer, List<String>> map4 = 
            mapStrm4.collect(
                Collectors.groupingBy(String::length)
            );
        System.out.println( map4 );

        // 10.
        // Stream to Map 5
        // groupingBy must return a non null value
        // Stream<String> mapStrm5 = Stream.of(null, "tiger", null, "timberfox");
        // Map<Integer, List<String>> map5 = 
        //     mapStrm5.collect(
        //         Collectors.groupingBy(String::length) // NullPointerException
        //     );
        // System.out.println( map5 );
        
        // 11.
        // Stream to Map 6
        // groupingBy
        // Values List to set
        Stream<String> mapStrm6 = Stream.of("lion", "tiger", "zebra", "tiger", "timberfox");
        Map<Integer, Set<String>> map6 = 
            mapStrm6.collect(
                Collectors.groupingBy(String::length, Collectors.toSet())
            );
        System.out.println( map6 );

        // 12.
        // Stream to Map 7
        // groupingBy
        // Return type from Map to TreeMap
        Stream<String> mapStrm7 = Stream.of("lion", "tiger", "zebra", "tiger", "timberfox");
        TreeMap<Integer, Set<String>> map7 = 
            mapStrm7.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet())
            );
        System.out.println( map7 );

        // 13.
        // Stream to Map 8
        // partitioningBy
        // Partition the list
        Stream<String> mapStrm8 = Stream.of("lion", "tiger", "zebra", "tiger", "timberfox");
        Map<Boolean, List<String>> map8 = 
            mapStrm8.collect(
                Collectors.partitioningBy(s -> s.length() == 5 )
            );
        System.out.println( map8 );

        // 14.
        // Stream to Map 9
        // partitioningBy
        // Partition value type from list to set
        Stream<String> mapStrm9 = Stream.of("lion", "tiger", "zebra", "tiger", "timberfox");
        Map<Boolean, Set<String>> map9 = 
            mapStrm9.collect(
                Collectors.partitioningBy(s -> s.length() == 5, Collectors.toSet() )
            );
        System.out.println( map9 );

        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate();
            
        var result = Stream.generate(() -> "")
           .limit(10)
           .filter(notEmpty)
           .collect(Collectors.groupingBy(k -> k))
           .entrySet()
           .stream()
           .map(Entry::getValue)
           .flatMap(Collection::stream)
           .collect(Collectors.partitioningBy(notEmpty));
        System.out.println(result);


        // 15.
        // Stream<Integer> stream = Stream.of(1, 2);
        // Cannot invoke filter((<no type> i) -> {}) on the primitive type boolean
        // Optional<Integer> optional = stream
        //     .anyMatch(i -> i % 2 == 0)
        //     .filter(i -> i % 2 == 1)
        //     .findAny();
        // System.out.println(optional.get());

        // 16.
        // There is a filter(Predicate) in Optional class as well
        // 
        try{
            Stream<Integer> stream = Stream.of(1, 3);
            Optional<Integer> optional = stream.findAny().filter(i -> i % 2 == 0);
            System.out.println(optional.get());
        } catch ( Exception e) {
            e.printStackTrace();
        }

        // 17.
        // ifPresentOrElse
        // Lambda expression's signature does not match the signature of the functional interface method run()
        // Stream
        //     .of(0)
        //     .findAny()
        //     .or(() -> Optional.of(1))
        //     .ifPresentOrElse(System.out::println,
        //         i -> System.out.println(i));

        // 18. 
        // reduce accepts the identity of type same as passed to BinaryOperator
        Daata data1 = new Daata(1);
        Daata data2 = new Daata(2);
        // Type mismatch: cannot convert from int to Data
        // Daata java.util.stream.Stream.reduce(Daata identity, BinaryOperator<Daata> accumulator)
        // Object res = Stream.of(data1, data2).reduce(1, (d1, d2) -> d1.number + d2.number);
        // System.out.println(res);
    }
}


class Daata {
    int number;

    Daata(int number) {
        this.number = number;
    }
}
