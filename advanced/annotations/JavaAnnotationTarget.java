import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class JavaAnnotationTarget {
    
}

// 1.
// Setting Target as Method and Constructor

@Target( { ElementType.METHOD, ElementType.CONSTRUCTOR } )
@interface ZooAttraction {}

// @ZooAttraction // WILL NOT COMPILE
class Events {

    // private @ZooAttraction int nrEvents; // WILL NOT COMPILE

    public @ZooAttraction Events() {}

    public @ZooAttraction void getEvents() {}

}

// End of 1

// 2.
// TYPE_USE 
// Annotation can be used anywhere where there is Java type
@Target(ElementType.TYPE_USE)
@interface Technical {}

@Technical class TechnologyBusiness {}

@Technical
class ITPark {

    class CallCenter extends @Technical TechnologyBusiness {

        public void callingInfra() {
            TechnologyBusiness tb = new @Technical TechnologyBusiness(){};
        
            TechnologyBusiness tbs = (@Technical TechnologyBusiness) tb;
        
        }
        
    }

}
