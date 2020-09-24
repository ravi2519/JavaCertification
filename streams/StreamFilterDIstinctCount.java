package streams;

import java.util.stream.Stream;

public class StreamFilterDIstinctCount {

    public static void main(String[] args) {

        Person p1 = new Person("John");
        Person p2 = new Person("Jane");
        Person p3 = new Person("Jane");
        Person p4 = new Person("Mark");
        Stream<Person> stream = Stream.of(p1, p2, p3, p4);

        // Returns 3
        long count = stream.filter(p -> p.name.startsWith("J")).distinct().count();
        System.out.println(count);

    }

}

class Person {
    String name;

    Person( String name) {
        this.name = name;
    }
}
