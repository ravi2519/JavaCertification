package streams;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExtra
{
    public static void main(String ... args) {
    		Predicate<Manager> isGood = manager -> false;
    		testEmployee(emp -> false);
	
    		// compile error
    		// testEmployee(manager -> isGood.test(manager));
    		// testEmployee2(manager -> isGood.test(manager));
    		System.out.println( testEmployee((Manager manager) -> isGood.test(manager)) );
    		System.out.println( testEmployee2((Manager manager) -> isGood.test(manager)) );
    }
	
    public static Employee createEmployee(Supplier<? extends Employee> factory) {
    		return factory.get();
    }
    
    public static <E extends Employee> boolean testEmployee(Predicate<E> theTest) {
    		return theTest.test(null);
    }
    
    public static boolean testEmployee2(Predicate<? extends Employee> theTest) {
    		return theTest.test(null);
    }
}
