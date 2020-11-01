
public class JavaDifferentAnnotations {

    public static void main(String[] args) {
        System.out.println("Main");
    }
    
}

// 1. Annotations can be used with interfaces
@FunctionalInterface interface Speedster {
    void go( String name);
}

// 2. Annotations can be used on classes
@LongEars
@Soft @Cuddly class Rabbit {}

// 3. Annotations can be used on constructors
class Snake {
    @Depricated public Snake() {}
}

// 4. Annotations can be used on arguments/parameters
class Moon {
    public Moon(@NotNull String planet) {}
}

// 5. Annotations can be used on methods
class Automobile {
    @Speed( velocity = "fast" ) public void car() {}
}

// 6. Annotations can be used with static, instance and local variables
class Dinner {
    @Food(vegetarian = true) private static String saag = "Sarson";
    @Food(vegetarian = true) public String kheer = "Sweet Dish";

    public void getMeFood() {
        @Food(vegetarian = false) String chicken = "Chicken Fry";
    }

}

// 7. Annotations can be used as cast expression
class Plants {
    String type;
    public Plants ( String type ) {
        this.type = (@CarbonBased String) type;
    }
}

// 8. Annotations can be used on other Annotations
@LocalAnnotation @interface LongEars {}


// 9. Annotations can also have a value. i.e. written without 
// an elemment name. For this the
// - annotation declaration must have a field with name "value" which 
//          can be either default or required
// - annotation declaration must not contain anyother elements that
//          are required
// - annotation usage must not provide values for other elemnets
@interface TransactionType {
    String value();
    int nr() default 20;
}

@TransactionType("Debit")
class DebitTransactions{}

@TransactionType(value="Credit")
class CreditTransactions{}

@TransactionType("Scam")
class UnknownTransactions{}

// DOES NOT COMPILE
// @TransactionType("Card", nr=10)
// class CardTransactions{}

// end of 9



@interface LocalAnnotation {}
@interface Soft {}
@interface Cuddly {}
@interface Depricated {}
@interface NotNull {}
@interface Speed {
    String velocity();
}
@interface Food {
    boolean vegetarian();
}
@interface CarbonBased {}