package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsFromArrays {
    
    public static void main(String[] args) {
        
        Stream<Employee> empStream = Arrays.stream(Employee.SOME);
        empStream
            .map( Employee::getSalary )
            .forEach(  System.out::println );
        
        Stream<Employee> partOfEmpStream = Arrays.stream(Employee.SOME, 2,5);
        partOfEmpStream
            .map( Employee::getSalary )
            .forEach(  System.out::println );
        
    }

}
