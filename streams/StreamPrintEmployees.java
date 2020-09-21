package streams;

import java.util.Arrays;

/**
 * StreamPrintEmployees
 */
public class StreamPrintEmployees {

    public static void main(String[] args) {
        
        Employee[] emps = Employee.SOME;

        Arrays
            .stream(emps)
            .filter( e -> e.getSalary() >= 2500 )
            .map( Employee::getName )
            .forEach( System.out::println );

    }
}