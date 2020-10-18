import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PrimitiveIterator.OfDouble;

// Comparable
// ==========
// - Comparable is an interface
// - Its has just one method
//      public interface Comparable<T> {
//          int compareTo(T o);
//      }
// - If a class implements the Comparable then
//   it can be used inside Collections.sort
// - natural odering that uses compareTo is said
//   to be consistent with equals if, and only if
//   x.equals(y) is true whenever x.compareTo(y) is 0.
//   Similarlly x.equals(y) is false whenever x.compareTo(y)
//   is not 0
// - its in java.lang package

// Comparator
// ==========
// - As seen above the class need to implement Comparable
//   to sort. Meanwhile Comparator can be used anywhere without
//   altering the class structure or code.
// - Collections.sort accepts second argument as Comparator 
//   to effectively sort the collections.
// - we need to override compare method
// - its in java.util package
// - its a functional interface

public class JavaSorting {
  
    public static void main(String[] args) {

        // 1.
        // Duck class implements Comparable
        // We are creating a list and then passing
        // it to Collections.sort
        var ducks = new ArrayList<Duck>();
        ducks.add( new Duck("Quack", 10, 40) );
        ducks.add( new Duck("Puddles", 12, 29) );
        ducks.add( new Duck("Rubber", 12, 19) );

        Collections.sort( ducks );
        System.out.println(ducks);

        // 2.
        // Using Comparator to bring the weight of
        // the ducks in comparison 
        Comparator<Duck> byWeight = new Comparator<Duck>(){
            @Override
            public int compare(Duck o1, Duck o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        Collections.sort(ducks, byWeight);
        System.out.println(ducks);

        // 3.
        // Since Comparator is a functional interface, we can 
        // use lambda expression
        Comparator<Duck> byWeightLambda = 
            (d1, d2) -> d2.getWeight() - d1.getWeight();

        Collections.sort(ducks, byWeightLambda);
        System.out.println(ducks);
    
        // 4.
        // we can also make use of the static reference from
        // Comparator class here
        Comparator<Duck> byWeightStaticRef = 
            Comparator.comparing(Duck::getWeight);
        
        Collections.sort(ducks, byWeightStaticRef);
        System.out.println(ducks);
        
        // 5.
        // There may be a requirement to do a comparison of
        // some complex compare methods. e.g. if weight is same then
        // sort by age
        // In that case we could either write a complex class implement 
        // and doing all sort of wizardry or we could use some static methods
        Comparator<Duck> byWeightAndAge = 
            Comparator.comparingInt(Duck::getWeight)
                      .thenComparingInt(Duck::getAge);

        Collections.sort(ducks, byWeightAndAge);
        System.out.println(ducks);

        // 6.
        // Using Collections.sort on non-comparable classes will cause
        // compile time error
        var dogs = new ArrayList<Dog>();
        dogs.add( new Dog("Pug") );
        dogs.add( new Dog("St Bernard") );
        dogs.add( new Dog("Husky") );

        // ( The method sort(List<T>) in the type Collections is not
        //   applicable for the arguments (ArrayList<Dog>) )
        // UNCOMMENT BELOW
        // Collections.sort(dogs);
                      
    }

}


// Genrics is important here. If we don't set it
// here then Java assume that we want to use Object
// in the compareTo method.
class Duck implements Comparable<Duck> {
    private String name;
    private int weight;
    private int age;

    public Duck (String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }

    public String toString() {
        return this.name + " " + this.weight + " " + this.age;
    }
}


class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}