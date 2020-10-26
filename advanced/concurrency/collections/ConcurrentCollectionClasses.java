package collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ConcurrentCollectionClasses {
    
    public static void main(String[] args) {
        
        // 1.
        // ConcurrentSkipListSet is the concurrent counterpart of TreeSet
        // It maintain its elements in natural ordering of the elements.
        Set<String> alphabets = new ConcurrentSkipListSet<>();
        alphabets.add("A");
        alphabets.add("E");
        alphabets.add("B");
        alphabets.add("C");
        alphabets.add("F");
        alphabets.add("D");
        System.out.println( alphabets.stream().collect(Collectors.joining(", ")) ); // A, B, C, D, E, F

        // 2.
        // ConcurrentSkipListMap is the concurrent counterpart of TreeMap
        // It also maintains its keys in natural ordering of the keys
        Map<String, Integer> alphaPosMap = new ConcurrentSkipListMap<>();
        alphaPosMap.put("A", 1);
        alphaPosMap.put("E", 2);
        alphaPosMap.put("B", 3);
        alphaPosMap.put("C", 4);
        alphaPosMap.put("F", 5);
        alphaPosMap.put("D", 6);
        alphaPosMap
            .entrySet()
            .stream()
            .forEach((e) -> System.out.println( e.getKey() + " - " + e.getValue()));

        // Above code will result in:
        // A - 1
        // B - 3
        // C - 4
        // D - 6
        // E - 2
        // F - 5

        // 3.
        // CopyOnWriteArrayList
        // Whenever they get modified, the data gets copied over to a new 
        // List/ArrayList.
        // They are suitable for the places where we need to iterate the collections
        List<Integer> lstOfInts = new CopyOnWriteArrayList<>(List.of( 8, 12, 46));
        for ( var i : lstOfInts ) {
            System.out.println(i);
            lstOfInts.add(80);
        } // 8 12 46
        System.out.println(lstOfInts.size()); // 6
        System.out.println(lstOfInts); // [8, 12, 46, 80, 80, 80]

        // 4.
        // CopyOnWriteArraySet also works in similar manner as above

        

    }

}
