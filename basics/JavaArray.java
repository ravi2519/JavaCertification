package basics;

import java.util.ArrayList;

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



    }
}
