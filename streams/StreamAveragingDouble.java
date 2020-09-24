package streams;

import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAveragingDouble {

    public static void main(String[] args) {

        Student s1 = new Student("Alice", "Business", 7.0);
        Student s2 = new Student("Bob", "Business", 9.0);
        Student s3 = new Student("Christine", "Engineering", 8.0);
        Student s4 = new Student("Daniel", "Engineering", 8.0);
        Stream<Student> stream = Stream.of(s1, s2, s3, s4);
        ToDoubleFunction<Student> f = Student::getMark;

        // Prints:
        // 8.0
        // 8.0
        stream.collect(Collectors.groupingBy(Student::getFaculty)).forEach((a, b) -> {
            double ave = b.stream().collect(Collectors.averagingDouble(f));
            System.out.println(ave);
        });

    }
}

class Student {
    private String name;
    private String faculty;
    private double mark;

    Student(String name, String faculty, double mark) {
        this.name = name;
        this.faculty = faculty;
        this.mark = mark;
    }

    String getName() {
        return name;
    }

    String getFaculty() {
        return faculty;
    }

    double getMark() {
        return mark;
    }
}
