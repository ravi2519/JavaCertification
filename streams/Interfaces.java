package streams;

import java.util.Comparator;

public class Interfaces {
	public static void main(String[] args) {
		
		Employee mike = new Employee("Mike", 2000),
 				 louise = new Employee("Louise", 2500);	 
		
		Comparator<Employee> byName = new Comparator<Employee>() {
			public int compare(Employee a, Employee b) {
				return a.getName().compareTo(b.getName());
			}
		};

		System.out.println("By name:");
		System.out.println(byName.compare(mike, louise));
		try {
			// throws NPE
			System.out.println(byName.compare(mike, null));
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		
		// a static method in Comparator
		Comparator<Employee> byNameThenNull = Comparator.nullsLast(byName);

		System.out.println("Then null:");
		System.out.println(byNameThenNull.compare(mike, louise));
		System.out.println(byNameThenNull.compare(mike, null));
		
		// a default method in Comparator
		Comparator<Employee> nullThenByDecreasingName = byNameThenNull.reversed();

		System.out.println("Reversed:");
		System.out.println(nullThenByDecreasingName.compare(mike, louise));
		System.out.println(nullThenByDecreasingName.compare(mike, null));
	}
}
