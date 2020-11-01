
// 1. Annotations are marked with @interface
public @interface JavaAnnotation {
    // 2. Fields

    // If a field does not have a default value then it acts as mandatory.
    // If it is not present with the definition of this
    // annotation then that will be compile time error
    int hoursPerDay();

    // this is how we set the field as optional for the annotation
    // the default must be non-null constant expression
    int startHour() default 6;

    // default can't be declared like this
    // UNCOMMENT BELOW
    // String name() default new String("");

    // default can't be null
    // UNCOMMENT BELOW
    // String title() default null;
}

// 3. 
// Valid use, where mandatory field was set and optional field was not touched.
@JavaAnnotation(hoursPerDay = 3) class Cheetah {}

// 4. 
// Annotation fileds must be inside the parenthesis '()'
// UNCOMMENT BELOW
// @JavaAnnotation hoursPerDay = 3 class Sloth {}

// 5. 
// Fields are mandatory
// UNCOMMENT BELOW
// @JavaAnnotation class ZooEmployee {}

// 6.
// Using a mandatory and optional field. Order doesnot matter here.
@JavaAnnotation(hoursPerDay = 2, startHour = 8) class Monkey {}

// 7.
// Setting optional field with different data type will cause compile time erro
// UNCOMMENT BELOW
// @JavaAnnotation(hoursPerDay = 2, startHour = "8 AM") class Donkey {}


