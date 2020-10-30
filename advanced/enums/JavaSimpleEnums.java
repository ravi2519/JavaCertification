
enum Season {
    WINTER, SPRING, SUMMER, FALL
}

// enums can't be extended
// enum ExtendedSeason extends Season {}

// enums can't be implemented like interfaces
// enum ImplemetedSeason implements Season {}

public class JavaSimpleEnums {

    public static void main(String[] args) {
        Season s = Season.WINTER;
        // System.out.println( s == "WINTER" ); // Incompatible operand types Season and String
        System.out.println( s ); // WINTER
        System.out.println( s == Season.WINTER ); // true
        
        // values(), name() and ordinal()
        for( Season ssn : Season.values() ) {
            System.out.println( ssn.name() + " " + ssn.ordinal() );
        }

        // can't compare with intger
        // if( Season.SPRING == 1 ) {
        //     System.out.println("SPRING is 1");
        // }

        System.out.println( Season.valueOf("WINTER") ); // WINTER
        // System.out.println( Season.valueOf("winter") ); // Exception:  No enum constant advanced.Season.winter


        // Enums in switch
        Season summer = Season.SUMMER;

        switch( summer ) {
            case WINTER:
                System.out.println("Its Winter");
                break;

            // DOES NOT COMPILE
            // case Season.SUMMER:
            //     System.out.println("Its Summer");
            //     break;

            // DOES NOT COMPILE
            // case 2: 
            //     System.out.println("Its Winter");
            //     break;
        
            default:
                break;
        }
        

    }
    
    
}
