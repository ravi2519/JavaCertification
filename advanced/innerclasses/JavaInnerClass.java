package advanced.innerclasses;

public class JavaInnerClass {

    private int outerClassVariable = 1;

    public JavaInnerClass() {
        outerClassVariable = 2;
    }

    public void outerMethod(){}
    
    // 1. Inner class can be public
    public class PublicInnerClass {}

    // 2. Inner class can be protected
    protected class ProtectedInnerClass {}

    // 3. Inner class can be private
    private class PrivateInnerClass {}

    // 4. Inner class can be package-private( default )
    class DefaultInnerClass {}

    // 5. Inner class can be Abstract
    abstract class AbstractInnerClass {}

    // 6. Inner class can be Final as well
    final class FinalInnerClass {}

    // 7. Can extend any other inner class or outer classes
    class ChildClass extends AbstractInnerClass {}
    // even its own class when it is present
    class ChildInnerClass extends JavaInnerClass {}
    
    class InnerClassFields {
        // 8. Inner class cann't have the static fields
        // public static String field1 ="Field 1";

        // 9. Inner class can't have static methods
        // public static String method1() {
        //     return "Method 1";
        // }

        // 10. Inner class can have static final fields
        public static final String field2 ="Field 2";

        // 11. Inner classes can't have static final methods
        // public static final String method2() {
        //     return "Method 2";
        // }

        public InnerClassFields() {

            // 12. Inner class Can access private outer class variables
            System.out.println(outerClassVariable);
        }

        // 13. Inner class can have normal initilizers
        {
            System.out.println("Inner class initilizer block");
        }

        // 14. Inner class CANNOT have static initilizers
        // static {
        //     System.out.println("Inner class staic initilizer block");
        // }


        // 15. Inner class can have exactly same variable names and method names 
        // as outer classes
        private class InnerClassWithSameVariables {
            public int outerClassVariable = 2;

            public void outerMethod(){}
        }

        

    } // end of an inner class

    // 16. Multiple inner classes accessing same variabl
    private int x = 0;
    class A {
        private int x = 10;

        class B {
            private int x = 20;

            class C {
                private int x = 30;

                public void printAllXs() {
                    System.out.println(x);
                    
                    System.out.println(this.x);

                    System.out.println(B.this.x);

                    System.out.println(A.this.x);

                    // can also be modified
                    B.this.x = 20;
                    System.out.println(B.this.x);

                }
            }
        }
    }

    public static void main(String[] args) {
            
        // 17. Inner class can be initialized using outer class
        JavaInnerClass outerClass = new JavaInnerClass();
        PrivateInnerClass innerClass = outerClass.new PrivateInnerClass();

        // 18. Weired way to access Inner classes
        A a = outerClass.new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.printAllXs();

    }

    public void someMethod() {
        // 19. Inner classes object can be created inside instance methods
        new PrivateInnerClass();
    }

    public static void someStaticMethod() {
        // 20. Inner classes objects can't be created inside class methods ( static ) 
        // new PrivateInnerClass();
    }

}
