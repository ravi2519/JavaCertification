
class Bear {}

enum Size { SMALL, MEDIUM, LARGE; }

// Annotation fields must be any of 
// - primitive type
// - string
// - class
// - enum
// - another annotation
// - array of any of the above types
public @interface JavaAnnotationFields {
    
    // INVALID FIELD
    // Wrapper classes of primitive types not allowed
    // Integer height();

    // INVALID FIELD
    // While String[] is valid, the 2-d array is not valid field
    // String[][] generalInfo();

    // VALID FIELD
    // an enum is valid
    Size size() default Size.SMALL;

    // INVALID FIELD
    // The type is Bear and not a class
    // Even if the Bear was an interfcae, this won't be a valid field
    // Bear cuddlyAnimal();

    // VALID FIELD
    // These fields are implicilty public and abstract if not defined
    public abstract int softness() default 10;

    // INVALID FIELD
    // Fields are implicitly public and abstract, thus setting them to
    // private won't compile
    // private int hardness() default 0;

    // INVALID FIELD
    // Fields are implicitly public and abstract, thus setting them to
    // protceted won't compile
    // protected int lazyness() default 100;

    // INVALID FIELD
    // Fields are implicitly public and abstract, thus setting them to
    // final won't compile
    // public final int sleepyness() default 200;

    // VALID CONSTANT
    // Annotations can have constants that can be accessed by other classes
    // without actually creating an annotation.
    // These variables are implicitly public static final
    public final static int MAX_CURRENT = 6;

    // VALID CONSTANT
    // implicitly public static and final
    int MAX_VOLATGE = 400;
}

///////////////////////////////////////////////////
// Providing an array value
@interface Businesses {
    String[] value();
}

// VALID array value annotation
@Businesses( value = {"Music", "Streaming", "Online Stores"} )
class Amazon{}

// VALID single array value annotation
@Businesses( value = {"Smartphone"} )
class Apple{}

// VALID single array value annotation
@Businesses( value = "Service" )
class Infosys{}

// VALID single array value annotation
@Businesses( "Rockets" )
class SpaceX{}

// VALID single array value annotation
@Businesses( {"Electric Cars"} )
class Tesla{}
//////////////////////////////////////////////////////