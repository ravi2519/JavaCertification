package advanced.enums;


// A complicated Enum
// only private constructors are allowed
// private, public, protected, default variables are allowed
// private and public methods are allowed as well 
enum ComplicatedSeason {
    WINTER("low", 10), SPRING("high", 20), SUMMER("high", 90), FALL("medium", 30);

    // not madatory to mark this final
    private final String expectedRain;
    public int humidity;
    protected String rainMeasure;
    double dayLength;

    // COMPILE TIME ERROR
    // Only private constructors are allowed
    // public ComplicatedSeason( String expectedRain ) {
    //     this.expectedRain = expectedRain;
    // }

    private ComplicatedSeason( String expectedRain, int humidity ) {
        this.expectedRain = expectedRain;
        this.humidity = humidity;
        System.out.println("Constructing");
    }

    public void printRain() {
        System.out.println(expectedRain);
    }

    
}

public class JavaComplicatedEnums {

    public static void main(String[] args) {
         // this is how the constructor of the complicated enum works
         System.out.println("Begin");
         ComplicatedSeason cw = ComplicatedSeason.WINTER;    // Constructing
                                                             // Constructing
                                                             // Constructing
                                                             // Constructing
         System.out.println("Midway");
         cw = ComplicatedSeason.WINTER; // --nothing
         System.out.println("Ends");
 
         // calling complicated enum methods and fields
         ComplicatedSeason.FALL.printRain(); // medium
         ComplicatedSeason.FALL.rainMeasure = "Scattered";
         ComplicatedSeason.FALL.dayLength = 6.0;
         ComplicatedSeason.FALL.humidity = 20;
         System.out.println(ComplicatedSeason.FALL); // FALL
 
    }
    
}
