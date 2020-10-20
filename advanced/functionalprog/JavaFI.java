import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class JavaFI {
    
    public static void main(String[] args) {
     
        // Accepts nothing but return ( get )
        createSuppliers();

        // Accepts but return nothing ( accepts )
        createConsumers();

        // Accepts and return a boolean ( test )
        createPredicates();

        // Accepts and return same or different type ( apply )
        createFunctions();

        // Accepts and return same type ( apply )
        createOperators();

        covenienceMethods();
    }

    public static void createSuppliers() {

        // 1.
        // Supplier

        Supplier<LocalDate> s1 = LocalDate::now;
        System.out.println( s1.get() );

        Supplier<LocalDate> s2 = () -> LocalDate.now();
        System.out.println( s2.get() );

        // The type of println() is void, thus can't be used here
        // Supplier<String> s3 = System.out::println;

        Supplier<ArrayList<String>> s4 = ArrayList<String>::new;
        List<String> o1 = s4.get();
        System.out.println(o1);

        // Type mismatch: cannot convert from ArrayList<String> to List<StringBuilder>
        // List<StringBuilder> o2 =s4.get();

        // Type mismatch: cannot convert from ArrayList<String> to List<CharSequence>
        // List<CharSequence> o3 =s4.get();

    }

    public static void createConsumers() {

        Consumer<String> c1 = System.out::println;
        c1.accept("Consumer 1");

        Consumer<String> c2 = (s) -> System.out.println(s);
        c2.accept("Consumer 2");

        var map = new HashMap<Integer, String>();
        BiConsumer<Integer, String> c3 = map::put;

        c3.accept(1, "First");
        c3.accept(2, "Second");

        System.out.println(map);

    }

    public static void createPredicates() {

        Predicate<String> p1 =String::isEmpty;
        System.out.println(p1.test(""));
        String s = "    ";
        System.out.println(p1.test(s));
        
        Predicate<String> p2 = str -> str.isBlank();
        System.out.println(p2.test(s));
        
        BiPredicate<String, String> p3 = String::startsWith;
        System.out.println( p3.test(s, " "));
        
    }

    public static void createFunctions() {

        Function<String, Integer> f1 = String::length;
        System.out.println( f1.apply("hello"));

        Function<String, Integer> f2 = s -> s.length();
        System.out.println( f2.apply("bonjour"));

        BiFunction<String, String, String> b1 = String::concat;
        System.out.println( b1.apply("Bi", "Function") ); 

    }

    public static void createOperators() {

        UnaryOperator<String> uo1 = String::toUpperCase;
        System.out.println(uo1.apply("hey you"));

        UnaryOperator<Integer> uo2 = Integer::signum;
        System.out.println( uo2.apply(-20));

        BinaryOperator<Integer> bo1 = Integer::sum;
        System.out.println(bo1.apply(2222, 3333));
    }

    public static void covenienceMethods() {

        // Predicate
        //  -   and (Predicate)
        //  -   or (Predicate)
        //  -   negate ()

        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = String::isBlank;

        Predicate<String> pAnd = p2.and(p1);
        System.out.println(pAnd.test("   "));
        
        Predicate<String> pOr = p2.or(p1);
        System.out.println(pOr.test("   "));

          
        Predicate<String> pNegate = p2.negate();
        System.out.println(pNegate.test("   "));

        // Consumer
        //  -   andThen

        Consumer<String> c1 = System.out::print;
        Consumer<String> c2 = System.out::print;
        Consumer<String> c3 = System.out::println;
        
        Consumer<String> cAndThenC = c1.andThen(c2).andThen(c3);

        cAndThenC.accept("Consumer ");

        // Function
        //  -   andThen ( Function ) -> left to right
        //  -   compose ( Function ) -> right to left

        Function<Integer, Integer> f1 = x -> x + 1;
        Function<Integer, Integer> f2 = x -> x * 2;
        Function<Integer, Integer> fAndThen = f1.andThen(f2);
        Function<Integer, Integer> fCompose = f1.compose(f2);

        System.out.println(fAndThen.apply(20)); // 42
        System.out.println(fCompose.apply(20)); // 41
        
        
    }

}
