import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

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

        // 8.
        // merge
        // This method is a step ahead of putIfAbsent where instead of 
        // deciding to replace or not replace values with similar key,
        // it provide an option for a BiFunction which can decide which
        // value to put in. If the key doesn't exist then it adds that key to
        // the map.
        // map.merge( key, newvalue, mapper
        BiFunction<String, String, String> mapper = 
            (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        
        Map<String, String> favs = new HashMap<>();
        favs.put("Jenny", "Bus Tour");
        favs.put("Tom", "Tram");
        favs.put("Ron", null);
        favs.put(null, "Walk");

        String jenny = favs.merge("Jenny", "Skyride", mapper);
        String tom = favs.merge("Tom", "Skyride", mapper);
        String unknowm = favs.merge("Unknown", "what", mapper);
        String ron = favs.merge("Ron", "Cycle", mapper); // BiFunction is not called at all 
        String nul = favs.merge(null, "Run", mapper);

        System.out.println(favs); // {Ron=Cycle, null=Walk, Tom=Skyride, Unknown=what, Jenny=Bus Tour}
        System.out.println(jenny); // Bus Tour
        System.out.println(tom); // Skyride
        System.out.println(unknowm); // what
        System.out.println(ron); // Cycle
        System.out.println(nul); // Walk

        // if mapper function returns null then the key gets removed
        BiFunction<String, String, String> newMapper =
            (v1, v2) -> null;

        favs.put("Key", null);
        jenny = favs.merge("Jenny", "Skyride", newMapper);
        tom = favs.merge("Tom", "Skyride", newMapper);
        String key = favs.merge("Key", "Skyride", newMapper);
        
        System.out.println(jenny); // null
        System.out.println(tom); // null
        System.out.println(key); // skyride

        System.out.println(favs); // {Ron=Cycle, null=Walk, Unknown=what}

    }

}
