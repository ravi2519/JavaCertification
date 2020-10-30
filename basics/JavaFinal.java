
public class JavaFinal {
    
    // 1.
    // Final instance vairable must be assigned either:
    // - at the time of initialization 
    // - inside static or normal initializer
    // - inside constructore
    // constructor is the last place where it will be checked.

    // assigned during initalization
    private final int assignedAtInit = 1;

    // assigned in normal initializer
    private final int assignedInInitializer;
    
    {
        assignedInInitializer = 2;
    }

    // assigned in static initializer
    private final static int assignedInStaticInitializer;

    static {
        assignedInStaticInitializer = 3;
    }

    // assigned in a constructor
    // if there are multiple constructors then they should 
    // be initialized in all of them following the
    // accurate constructor path.
    private final int assignedInConstructor1;
    private final Integer assignedInConstructor2;

    public JavaFinal() {
        assignedInConstructor1 = 4;
        assignedInConstructor2 = 5;
    }

    public JavaFinal( int a ) {
        assignedInConstructor1 = 6;

        // a null can also be assigned to a final variable
        assignedInConstructor2 = null;
    }

    public JavaFinal( int a, int b ) {
        this();
    }

    public static void main(String[] args) {
        
        // 
        printInfo( 1 );
        printInfo( 2 );
        
    }

    public static void printInfo( int flag) {
        // final variable must be initialized
        final long len;
        if( flag == 1 ) len = 10;
        else len = 20;

        System.out.println(len);

        final String str;

        if( flag == 2 ) str = "none";
        else str = "one";

        System.out.println(str);


    }
}
