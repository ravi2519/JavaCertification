
import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {
    

    public static void main(String[] args) {
        
        // 1.
        // null can't be unboxed
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(null); // perfectlty fine
        //int num = lst.get(1); // NullPointerException

        // 2.
        // Here the printNames method will throw a 
        // ClassCastException. When we are not using 
        // the generics, then we may not be able to 
        // cast them properly
        List names = new ArrayList();
        names.add(new StringBuilder("movie")); // perfectly fine
        printNames(names);        

        // Instead if we use generics this will just gove us a compile time error
        List<String> namesLst = new ArrayList<>();
        // COMPILE ERROR BELOW
        // The method add(String) in the type List<String> is not applicable for the arguments (StringBuilder)
        // namesLst.add(new StringBuilder("series"));

        callRemaining();
    }

    // 3.
    // Generic methods
    // We need a formal type parameter <T>
    static <T> void one(T t) {}
    static <T> T two(T t) { return t; }
    // static T three(T t) { return t;} // (T cannot be resolved to a type)
    
    // 4.
    // When you have a method declare a generic parameter type, it is
    // independent of the class generics
    class Crate<T> {
        public <T> T ricky( T t ) { return t; }
    }

    static void printNames(List list) {
        for ( int i = 0; i< list.size(); i++ ) {
            String name = (String)list.get(0); // class java.lang.StringBuilder cannot be cast to class java.lang.String
        }
    }

    static void callRemaining() {
        // Bounding Generic Types
        // 5.
        // Wildcard generic Type
        // - Unbounded wildcard
        List<?> lsta = new ArrayList<>(); // perfeclty fine
        List<?> lstb = new ArrayList<String>();

        // - Upper bound wildcard
        List<? extends Exception> lstc = new ArrayList<RuntimeException>();

        // - Lower bound wildcard
        List<? super RuntimeException> lstd = new ArrayList<Exception>();
    
        // 6.
        // Assigning different generic types
        List<String> lste = new ArrayList<>();
        // List<String> can't be assigned to List<Object>
        // UNCOMMENT BELOW
        // printList(lste);

        // this can be corrected by having an implementation
        // of called method with an argument of any type
        genericPrintList(lste); // List<String> cand be assigned to List<?>

        // 7.
        // Assigning higher class list to lower class
        // COMPILE ERROR
        // Type mismatch: cannot convert from ArrayList<Integer> to List<Number>
        // List<Number> lstf = new ArrayList<Integer>();
        // This can be corrected using
        List<? extends Number> lstg = new ArrayList<Integer>();


        // 8.

    }

    static void printList(List<Object> lst) {
        for( Object x : lst ) {
            System.out.println(x);
        }
    }

    static void genericPrintList(List<?> lst) {
        for( Object x : lst ) {
            System.out.println(x);
        }
    }
        
}
