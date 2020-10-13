package advanced.innerclasses;

public class JavaAnonymousInnerClass {

    abstract class NormalInnerClass {
        abstract void doSomething();
    }

    public static void main(String[] args) {
        
        // 1. Anonymous class example
        JavaAnonymousInnerClass outerClassObj = new JavaAnonymousInnerClass();
        NormalInnerClass obj = outerClassObj.new NormalInnerClass() {
            void doSomething() {
                System.out.println("Doing something");
            }
        };

        obj.doSomething();

    }
    
}
