package advanced.innerclasses;

public class JavaLocalInnerClass {
    
    public void someMethod () {

        long innerClassVariable = 20L;
        long effectivelyFinalVariable = 10L;
        final long finalVariable = 30L;

        // 1. Local inner class can't be public
        // public class PublicLocalInnerClassInMethod {}

        // 2. Local inner class can't be private
        // private class PrivateLocalInnerClassInMethod {}

        // 3. Local inner class can't be protected
        // protected class ProtectedLocalInnerClassInMethod {}

        // 4. Local inner class can be default
        class DefaultLocalInnerClassInMethod {}

        // 5. Local inner class can be set as abstract 
        abstract class AbstractLocalInnerClassInMethod {}

        // 6. Local inner class can be set as final
        final class FinalLocalInnerClassInMethod {}

        // 7. Local inner class can't be a static
        // static class StaticLocalInnerClassInMethod {}

        innerClassVariable = 20 * innerClassVariable;

        class FieldsInLocalInnerClassInMethod {

            // 8. Local inner classes can have static final variables
            private static final String field1 = "Static Final";

            // 9. Local inner class can't have static fields 
            // (The field filed2 cannot be declared static in a
            // non-static inner type, unless initialized with a constant expression)
            // public static String filed2 = "Static Field";

            // 10. Can have normal methods with public, private, protected or default
            protected void normalMethod() {}

            // 11. Can't have a static method
            // public static void staticMethod() {}

            // 12. Since static methods are not allowed, the main is also not possible here
            // public static void main(String[] args) { }

            private void localInnerClassMethod() {

                
                // 13. Can access the enclosing class's variables and methods
                System.out.println( enclosingClassVariable );
                System.out.println( anotherMethod() );
                
                // 14. Can also access loca varibales of the enclosing method given that 
                // they are either final or effectively final
                System.out.println( effectivelyFinalVariable );
                System.out.println( finalVariable );
                // System.out.println(innerClassVariable); // COMPILE TIME ERROR

            }
        }
    }

    private int enclosingClassVariable = 20;

    public String anotherMethod() {
        return "YES";
    }

    {
        // 15.
        // Local inner class can be present inside the normal initializer
        class LocalInnerClassInNormalInitialiser {}
    }

    static {
        // 16.
        // Local inner class can be present inside the static initializer
        abstract class LocalInnerClassInStaticInitialiser {}
    }

    public JavaLocalInnerClass () {

        // 17. Local inner class can be present inside the constructor as well
        final class LocalInnerClassInConstructor {}
    }

}
