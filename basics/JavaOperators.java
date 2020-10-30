
public class JavaOperators {
    
    public static void main(String[] args) {
        
        // 1.
        // Can't use logical operators on numerics
        //( The operator ! is undefined for the argument type(s) int )
        // boolean peacock = !0;

        // 2.
        // binary operation on small data type like byte, short and char
        // makes the variable to promote to int first. The result will
        // be the type of promoted type.
        // in following case the result is of type int and thus can't be 
        // assigned to short.
        short x = 10;
        short y = 3;
        //( Type mismatch: cannot convert from int to short )
        // short z = x + y;
        // valid statement
        short z = (short) (x + y);
        System.out.println(z);

        // 3.
        // When using compund operators, the casting is done implicitly
        long goat = 10;
        int sheep = 5;
        sheep *= goat;
        System.out.println(sheep);

        // 4.
        // here as well 5 will be promoted to 5.0 and thus
        // isIt will have true
        boolean isIt = (5 == 5.0);
        System.out.println(isIt);

        // 5.
        // comparing null with null is true
        System.out.println(null == null);

        // 6.
        // Invalid instanceOf use
        Number time = 1;
        String str = "time";
        //( Incompatible conditional operand types Number and String )
        // System.out.println(time instanceof String);

        // 7.
        // right side of instanceof must not be a  null
        Object noObjectHere = null;
        //  (Incompatible conditional operand types Object and byte) 
        // System.out.println(noObjectHere instanceof null);


        // 8.
        // Ternary operator loop holes
        int stripes = 7;
        // Compile error
        // ( Type mismatch: cannot convert from String to int )
        // int animal = ( stripes < 10 ) ? 3 : "Horses";

        String horses = "Horses";
        // ( Type mismatch: cannot convert from String to int )
        // int animal = ( stripes < 10 ) ? 3 : horses;
    }
}
