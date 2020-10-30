
import java.util.ArrayList;
import java.util.List;

/**
 * WrapperClasses
 */
public class WrapperClasses {

    public static void main(String[] args) {
        
        // 1.
        // parseInt is to get primitive
        // valueOf is to get the wrapper class object
        int primitiveInt = Integer.parseInt("123");
        Integer wrapperInt = Integer.valueOf("232");
        System.out.println(primitiveInt);
        System.out.println(wrapperInt);

        // 2.
        // No issues here
        float fl = Float.valueOf("22");
        System.out.println(fl);

        // 3.
        // Unboxing a null will give null pointer
        List<Integer> heights = new ArrayList<Integer>();
        heights.add(null);
        // NUllPointerException in below code
        // int ht = heights.get(0);

        // 4.
        // Autoboxing integer issue
        List<Integer> widths = new ArrayList<Integer>();
        widths.add(1);
        widths.add(2);
        widths.remove(1); // this will not remove 1 but the element on index 1 i.e 2
        System.out.println(widths);
    }
}