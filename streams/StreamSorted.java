package streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamSorted {
    
    public static void main(String[] args) {
        
        Stream<Employee> empStream = Stream.of( Employee.SOME );
        empStream.sorted(
            Comparator.comparingInt(Employee::getSalary).reversed()
        ).limit(10)
        .map(Employee::getName)
        .forEachOrdered(System.out::println);

    }
}
