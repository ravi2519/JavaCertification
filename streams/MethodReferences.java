package streams;

import java.util.Comparator;
import java.util.function.*;

public class MethodReferences {

	interface ThreadSupplier {
		Thread giveMeAThread();
	}
	
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		// Static method
		Supplier<Thread> s1 = Thread::currentThread;
		
		
		// Nothing special about 'Supplier'...
		ThreadSupplier ts = Thread::currentThread;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Instance method (instance specified)
		Employee frank = new Employee("Frank", 3000);
		
		Integer i = frank.getSalary();
		Supplier<Integer> s2 = frank::getSalary;		
		
		System.out.println(s2.get());
		
		
		
		
		
		// A common instance method (instance specified)
		Consumer<String> c1 = System.out::println;

		
		
		
		
		
		
		
		
		
		
		// An instance method (instance not specified)
		Function<Employee,Integer> f1 = Employee::getSalary;
		
		Integer frankSalary = f1.apply(frank);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// A useful application: building a comparator based on a field
		
		// comparing expects Function<Employee, U>,
		// where U supports natural ordering (i.e., Comparable)
		
		Comparator<Employee> byName = 
				Comparator.comparing(Employee::getName);		

		
		
		
		
		
		
		
		
		
		
		
		main2();
	}		
		

	
	
	
	
	
	
	
	
	
	
	
	public static <T> void printAll(T[] array,
				                    Function<T,String> toStringFun) {
		int i = 0;
		for (T t: array)
			System.out.println(i++ + ":\t" + toStringFun.apply(t));
	}
		
		
	
	
	public static void main2() {
		
		Employee dept[] = new Employee[5];
		dept[0] = new Employee("Alec", 1500);
		dept[1] = new Employee("Bob", 1600);
		dept[2] = new Employee("Claire", 1700);
		dept[3] = new Employee("Danielle", 1800);
		dept[4] = new Employee("Ethan", 1900);
		printAll(dept, Employee::getName);

		System.out.println("");
		
		// Compile-time error: type inference failure
		// printAll(dept, Employee::getSalary);

		printAll(dept, emp -> "" + emp.getSalary());
		
	}	
}
