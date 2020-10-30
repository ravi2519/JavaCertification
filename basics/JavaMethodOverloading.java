
import java.util.List;

public class JavaMethodOverloading {

    // 1.
    // Valid method overloadings
    public void fly() {}
    public void fly( int numOfMiles) {}
    public boolean fly( boolean fly ) { return false; } 
    void fly( int numMiles, short numFeet ) {}
    public void fly ( short numMiles, int numFeet ) throws Exception {}

    // 2.
    // Invalid method overloading

    // parameters must differ
    // void fly() {}

    // arrays and varargs are same in overloading
    // public void fly( int[] members ) {}
    // public void fly( int... members ) {}

    // no respect to generics
    // public void fly( List<Integer> lst) {}
    // public void fly( List<String> lst) {}
    


    // 3.
    // Autoboxing
    // Java will try to use the most specific parameter list
    // it can find.
    // so called(1) will print "Called primitive parameter method" 
    public void called( int arg ) {
        System.out.println("Called primitive parameter method");
    }

    public void called( Integer arg ) {
        System.out.println("Called wrapper class parameter method");
    }

    // 4.
    // Referrence type
    // Simillarly most specific parameter list will be called 
    // when we try with reference types
    public void referenceType( String arg ) {
        System.out.println("String");
    }

    public void referenceType( Object arg ) {
        System.out.println("Object");
    }


    // 5.
    // Primitives
    // Simillarly most specific parameter list will be called 
    // when we try with primitives
    public void primitiveType( short arg ) {
        System.out.println("Short");
    }

    public void primitiveType( int arg ) {
        System.out.println("int");
    }

    public void primitiveType( long arg ) {
        System.out.println("long");
    }

    public void primitiveType( Integer arg ) {
        System.out.println("Integer");
    }


    // 6.
    // Different primitive type
    // Java cannot convert smaller primitive type to larger autoboxed type
    // diffPrimitive(1) will fail
    public void diffPrimitive( Long arg) {
        System.out.println("long");
    }

    public void diffPrimitive( Long... arg ) {
        System.out.println("Long varargs");
    }

    public static void main(String[] args) {
        
        // 3.
        new JavaMethodOverloading().called(1);

        // 4.
        new JavaMethodOverloading().referenceType("arg");
        new JavaMethodOverloading().referenceType(3);

        // 5.
        new JavaMethodOverloading().primitiveType(1); // int
        new JavaMethodOverloading().primitiveType(400); // int
        new JavaMethodOverloading().primitiveType(1L); // long
        new JavaMethodOverloading().primitiveType(4444444444444444444L); // long
        new JavaMethodOverloading().primitiveType(Integer.valueOf(1)); // Integer
    
        // 6.
        //( The method diffPrimitive(Long) in the type JavaMethodOverloading
        // is not applicable for the arguments (int) )
        // new JavaMethodOverloading().diffPrimitive(2);
        new JavaMethodOverloading().diffPrimitive(2L);
        
    }
}
