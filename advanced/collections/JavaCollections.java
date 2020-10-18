package advanced.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class JavaCollections {
    

    public static void main(String[] args) {
        
        // 1.
        // Set don't allow duplicate values, so if we add them
        // they will return a false.
        Collection<String> list  = new ArrayList<>();
        System.out.println(list.add("First")); // true
        System.out.println(list.add("Second")); // true 
        System.out.println(list.add("First")); // true
        
        Collection<String> set = new HashSet<>();
        System.out.println(set.add("First")); // true
        System.out.println(set.add("Second")); // true 
        System.out.println(set.add("First")); // false

    }

}
