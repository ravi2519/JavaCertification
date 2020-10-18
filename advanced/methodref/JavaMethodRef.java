package advanced.methodref;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * JavaStaticMethodRef
 * 
 * Four formats for Method reference:
 * - Static methods
 * - Instance methods on a particular instance
 * - Innstance methods on a parameter to be determined at runtime
 * - Constructors
 * 
 */
public class JavaMethodRef {

    public static void main(String[] args) {
        
        // 1. 
        // Static method refernece
        // Collections.sort
        // sort is an overloaded method, i.e. it has implementaion with 
        // different parameters. Java decide which implementation to use 
        // based on context
        Consumer<List<Integer>> sortMethodRef = Collections::sort; // sortMethodRef.accept(t);
        Consumer<List<Integer>> sortLambda = x -> Collections.sort(x); // sortLambda.accept(t);
        
        // 2.
        // Instance method on a particular instance
        // String's startsWith method
        String str = "abc";
        Predicate<String> startsWithMethodRef = str::startsWith; // startsWithMethodRef.test(str)
        Predicate<String> startsWithLambda = s -> str.startsWith(s); // startsWithLambda.test(str)

        // Random's nextInt
        var random = new Random();
        Supplier<Integer> randMethodRef = random::nextInt; // randMethodRef.get();
        Supplier<Integer> randLambda = () -> random.nextInt(); // randLambda.get();

        // 3.
        // Instance method that doesn't take any parameter
        // isEmpty below looks like a static but it isn't a static
        // It also dosn't take any parameter. Java uses the parameter 
        // supplied at runtime as the instance on which the method is called. 
        Predicate<String> isEmptyMethodRef = String::isEmpty;
        Predicate<String> isEmptyLambda = s -> s.isEmpty();

        // Funtional reference that take two parameters
        // SInce the Functional interface takes two parameters,
        // java has to figure out what they represent in runtime
        BiPredicate<String, String> startsWithMethodref = String::startsWith;
        BiPredicate<String, String> startsWithLambdas = (s, p) -> s.startsWith(p);

        // 4.
        // Constructors
        Supplier<List<String>> constMethodRef = ArrayList::new;
        Supplier<List<String>> constLambda = () -> new ArrayList<String>();

        Function<Integer, List<String>> constMethodRef2 = ArrayList::new;
        Function<Integer, List<String>> constLambda2 = i -> new ArrayList<String>(i);


    }

}