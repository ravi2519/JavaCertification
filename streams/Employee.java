package streams;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee {
	private String name;
	private int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return name + ": " + salary;
	}
	
	public static final Employee[] SOME = {
			new Employee("Mike", 2500),
			new Employee("Frank", 3000),
			new Employee("Hannah", 2500),
			new Employee("Rajeev", 2000),
			new Employee("Jessica", 1500),
			new Employee("Doug", 2000),
			new Employee("Chen", 3500),
			new Employee("Krish", 2200),
			new Employee("Louie", 800)
		};
	
	private static Random rand = new Random();
	public static Employee[] randomlyGenerate(int n) {
		return Stream.generate(() -> {
			final int NAMELENGTH = 10;
			String name = "Pippo"; /* rand.ints(NAMELENGTH, 0, 25)
                    .mapToObj(i -> "" + (char)(61+i))
                    .collect(Collectors.joining()); */
			return new Employee(name, rand.nextInt(10000));
		}).limit(n).toArray(Employee[]::new);
	}
}
