package streams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectorsGroupingBy {

    public static void main(String[] args) {

        List<Integer> l1 = List.of(1);
        List<Integer> l2 = List.of(1, 2);
        List<Integer> l3 = List.of(2, 3);
        List<Integer> l4 = List.of(3, 4, 5);

        // Collectors.counting method returns a Collector<T,​ ?, ​Long> object. 
        // This means the result variable is of type Collection<Long>. 
        // Since the parameterized type of result is incorrect, the given code fails to compile.
        // Collection<Integer> result = 
        //     Stream.of(l1, l2, l3, l4).collect(
        //         Collectors.groupingBy( List::size, Collectors.counting()) ).values();
        
        // Correct way will be i.e. change the parameterized type of result form Integer to Long 
        Collection<Long> result = 
            Stream.of(l1, l2, l3, l4).collect(
                Collectors.groupingBy( List::size, Collectors.counting()) ).values();
        
        
        // [1, 2, 1]
        System.out.println(result);

    }
}
