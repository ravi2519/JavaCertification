package basics;

import java.util.ArrayList;

public class JavaStatic {

    static String staticVariable = "Static Variable";

    static void staticMethod(){
        System.out.println("Static Method");
    }

    private static final ArrayList<String> arrLst = new ArrayList<String>();

    // 3. -------------START -------------------
    private static final String leftRope;
    private static final String rightRope;
    // private static final String bench; 
    private static final String name = "name";
    static {
       leftRope = "left";
       rightRope = "right";
    }
    static {
    //    name = "name";
    //    rightRope = "right";
    }
    // 3. --------------END---------------------

    public static void main(String[] args) {
        
        // 1.
        // Static meber can also be accessed using the references
        // and even just the reference, i.e. even if we set it to
        // null
        JavaStatic js = new JavaStatic();
        System.out.println( js.staticVariable );
        js.staticMethod();

        js = null;
        System.out.println( js.staticVariable );
        
        // 2.
        // We cannot reinitialise the final members, but we can updated them
        arrLst.add("Value");

        // 3.
        // Compiler errors count - 4
        // bench = "4";
    }
    
}
