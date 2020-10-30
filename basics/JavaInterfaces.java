
// 1.
// Return type of fly() in CanFly and HasWings
// doesn't follow the overriding rules 
interface CanFly {
    int fly();

    String fly(int distance);
}

interface HasWings {
    abstract String fly();

    public abstract Object getWingSpan();
}

// UNCOMMENT BELOW
// abstract class Falcon implements CanFly, HasWings {
// }

// END OF 1


// 2.
// Using instanceof
interface Apple {
}

interface Orange {
}

class Gala implements Apple {
}

class Tangerine implements Orange {
}

final class Citrus extends Tangerine {
}

public class JavaInterfaces {
    public static void main(String... farm) {
        Gala g = new Gala();
        Tangerine t = new Tangerine();
        Citrus c = new Citrus();

        // Compiler error
        // Both t and Gala are classes, so they strictly give a 
        // compiler error when we use instanceof with them
        // UNCOMMENT BELOW
        // System.out.print(t instanceof Gala);
        
        // perfectly fine
        System.out.print(c instanceof Tangerine);
        
        // perfectly fine
        System.out.print(g instanceof Apple);
        
        // This doesnot throw a compiler error
        // the logic is that there may be a case where 
        // class Tangerine might be extended by some 
        // other class and that class implements Apple 
        System.out.print(t instanceof Apple);

        // Similar to above. But since CItrus is 
        // final it can't be overridden. Thus no implementation of
        // Apple in heirearchy. 
        // UNCOMMENT BELOW
        // System.out.print(c instanceof Apple);
    }
}

// END OF 2

interface Foo {
    default void m1() {
        m3(); // Line 1
        m4(); // Line 2
    }

    static void m2() {
        // m3(); // Line 3 Cannot make a static reference to the non-static method m3() from the type Foo
        m4(); // Line 4
    }

    private void m3() {
    }

    private static void m4() {
    }
}