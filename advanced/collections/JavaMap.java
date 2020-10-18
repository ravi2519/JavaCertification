import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JavaMap {
    
    public static void main(String[] args) {
        
        // 1.
        // put adds a key-value pair to the map.
        // if key already exists then replace the value and 
        // returns the replaced value
        Map<String, String> map = new TreeMap<>();
        System.out.println( map.put("koala", "bamboo") ); // null
        System.out.println( map.put("lion", "meat") ); // null
        System.out.println( map.put("giraffe", "leaf") ); // null
        System.out.println( map.put("lion", "goat") ); // meat

        // 2.
        // Map DOESNOT contain contains method
        // It has :x
        // - containsKey
        // - containsValue
        // Uncomment below
        // System.out.println(map.contains("lion"));
        System.out.println( map.containsKey("lion") );
        System.out.println( map.containsValue("sheep") );

        // 3.
        // forEach accepts a BiConsumer
        Map<Integer, Character> map2 = new HashMap<>();
        map2.put(1, 'a');
        map2.put(2, 'b');
        map2.put(3, 'c');
        // Method ref can't be used here
        // map.forEach((k, v) -> System.out::println );
        map.forEach((k, v) -> System.out.println(v) );

        // 4.
        // keySet and values returns a list of keys and values
        // respectively
        map2.keySet().forEach(System.out::println);
        map2.values().forEach(System.out::println);

        // entrySet returns a collection of Entry
        map.entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()) );

        // 5.
        // get return a null of key is not in the map
        System.out.println( map.get("monkey") ); // null

        // getOrDefault returns a default value of the key is 
        // not in the map
        System.out.println( map.getOrDefault("monkey", "NO MONKEY") ); // null

        // 6.
        // replace replaces a single value and return the original value
        System.out.println( map.replace("lion", "pizza")); // goat

        // replaceAll replaces all the values in the map.
        // It accepts a BiFunction 
        map.replaceAll((k, v) -> { return k + " eats " + v; } );
        map.values().forEach(v -> System.out.println(v) );


        // 7.
        // putIfAbsent
        // Puts the value in the map, but skips if it is already added.
        // It return null if it is able to add any value
        // But returns the original value if it is NOT able to add any value 
        map.put("cow", null);
        System.out.println( map.putIfAbsent("cow", "grass") ); // null
        System.out.println( map.putIfAbsent("cow", "meth") ); // grass
        System.out.println(map.get("cow")); // grass

    }

}
