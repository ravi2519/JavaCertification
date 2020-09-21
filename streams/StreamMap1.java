package streams;

import java.util.stream.Stream;

public class StreamMap1 {
    
    public static void main(String[] args) {
        
        Stream<Employee> empStream = Stream.of( Employee.SOME );
        empStream
            .map( Employee::getSalary )
            .filter( s-> s>1000)
            .forEachOrdered(System.out::println);


    }

}
