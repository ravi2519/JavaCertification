package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaArray {
    
    public static void main(String[] args) {
        
        // 1.
        // Without a dimension or array elements, a compiler erro is thrown
        // ( Variable must provide either dimension expressions or an array initializer )
        // int[] arr = new int[];
        // this is fine
        int[] arr = new int[0];
        System.out.println(arr.length); // 0

        // invalid
        // int[] arr2d[] = new int[][];
        
        // valid
        int[] arr2d[] = new int[5][];
        
        // invalid
        // int[] arr2d[] = new int[][5];
        
        // valid
        var arrVar = new int[10][];

        // 2.
        // No type with a var refernece will set the arraylist type to Object
        var arrList1 = new ArrayList<>();
        arrList1.add("20");
        // Invalid ( Type mismatch: cannot convert from element type Object to String )
        // for( String ele: arrList1 ) {
        //     System.out.println( ele );
        // }
        // Valid
        for( Object ele: arrList1 ) {
            System.out.println( ele );
        }

        // 3. 
        // If no generics are provided in the arraylist, then
        // we can add any type of object into it.
        /// Just the primitives are not allowed.
        ArrayList arrlst = new ArrayList<>();
        arrlst.add("Value");
        arrlst.add(Boolean.TRUE);
        System.out.println(arrlst);

        // 4.
        // we can't add to a list far into the index sequence
        List<String> birds = new ArrayList<String>();
        birds.add("hawk");
        birds.add(1, "robin");
        birds.add(1, "blue jay");
        birds.add(3, "cardinal");
        // throws runtime error
        //birds.add(8, "cardinal");
        System.out.println(birds);

        // 5.
        // Array to List using Arrays.asList create a fixed size backed list
        // any changes made to array or list will be reflected at both the places
        // If we try to remove the element from the array or the List then 
        // UnsupportedOperationException will be thrown.
        String[] array = { "hawk", "robin" };
        List<String> lst = Arrays.asList(array);
        lst.set(0, "blue jay");
        System.out.println(lst);
        array[1] = "new";
        System.out.println(lst);
        // lst.remove(1); // UnsupportedOperationException

        // 6.
        // Creating immutable List using List.of(arr)
        // We cannot change the size or the elements in such alist
        List<String> immlst = List.of(array);
        System.out.println(immlst);
        array[0] = "Test";
        System.out.println(Arrays.toString(array));
        // immlst.set(0, "Change"); // UnsupportedOperationException
        // immlst.remove(1);  // UnsupportedOperationException

        // 7.
        // binarySearch
        List<String> hex = Arrays.asList("30", "8", "3A", "FF");
        Collections.sort(hex);
        int x = Collections.binarySearch(hex, "8");
        int y = Collections.binarySearch(hex, "3A");
        int z = Collections.binarySearch(hex, "4F");
        System.out.println(x + " " + y + " " + z); // 2 1 -3

    }
}
