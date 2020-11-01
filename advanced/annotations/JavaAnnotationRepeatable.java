import java.lang.annotation.Repeatable;

public class JavaAnnotationRepeatable {
    
}

// Making this annotation as Repeatable, we need to do
// following

@interface Risks{
    // Must contain value
    Risk[] value();
}

@Repeatable( Risks.class )
@interface Risk {
    String danger();
    int level() default 1;
}


@Risks({
    @Risk(danger = "High"),
    @Risk(danger = "Average", level = 2)
})
class Momkey {}


