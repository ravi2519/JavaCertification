package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectorsToMap {

    public static void main(String[] args) {
        NewPerson p1 = new NewPerson("Andrew", Gender.MALE);
        NewPerson p2 = new NewPerson("Beatrice", Gender.FEMALE);
        NewPerson p3 = new NewPerson("Chris", Gender.MALE);
        NewPerson p4 = new NewPerson("Diana", Gender.FEMALE);
        Stream<NewPerson> persons = Stream.of(p1, p2, p3, p4);

        // Throws:
        // Exception in thread "main" java.lang.IllegalStateException: Duplicate key MALE (attempted merging values Andrew and Chris)
        System.out.println(persons.collect(Collectors.toMap(p -> p.gender, p -> p.name)));
    }

}

class NewPerson {
    String name;
    Gender gender;

    NewPerson(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}

enum Gender {
    MALE, FEMALE
}
