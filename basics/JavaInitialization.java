
/**
 * This is an important example showcasing all the possible 
 * initialization scenarios in the Java inheritance.
 * 
 */

class ParentJavaInitialization {

    static {
        System.out.println( "A. Parent Static Initialization Block");
    }

    {
        System.out.println( "B. Parent Normal Initialization Block" );
    }

    public ParentJavaInitialization (String name) {
        this(1);
        System.out.println( "C. Parent String Argument Constructor");
    }

    public ParentJavaInitialization() {
        System.out.println( "D. Parent No Argument Constructor");
    }

    public ParentJavaInitialization( int n ) {
        System.out.println( "E. Parent Int Argument Constructor");
    }

}

public class JavaInitialization extends ParentJavaInitialization {

    static {
        System.out.println( "F. Child Static Initialization Block");
    }

    public JavaInitialization(int n) {
        super("sugar");
        System.out.println( "G. Child int Argument Constructor");
    }
    
    public static void main(String[] args) {
        new JavaInitialization(1);
        System.out.println();
        new JavaInitialization(2);
    }

    {
        System.out.println( "H. Child Normal Initialization Block");
    }
}
