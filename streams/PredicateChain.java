package streams;

import java.util.function.Predicate;

public class PredicateChain {

    int i;

    PredicateChain(int i) {
        this.i = i;
    }
}

class Test {
    static boolean compare(PredicateChain foo, Predicate<PredicateChain> predicate) {
        return predicate.test(foo);
    }

    public static void main(String[] args) {
        Predicate<PredicateChain> p = f -> f.i > 0; // Line 1
        p = p.or(f -> f.i > 0).and(f -> f.i < 0); // Line 2
        boolean b = compare(new PredicateChain(1), p); // Line 3
        System.out.println(b);
    }
}
