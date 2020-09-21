package streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamFromCollection {

    public static void main(String[] args) {
        
        Collection<Employee> empColl = List.of( Employee.SOME );

        empColl.stream().forEach(System.out::println);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
        empColl.parallelStream().forEach( System.out::println);

    }
    
}
