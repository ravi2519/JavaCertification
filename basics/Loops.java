
public class Loops {
    
    public static void main(String[] args) {
        
        // 1.
        // Can't use incompatible data types in the initialization blocks
        // (Syntax error on token "int", delete this token)
        // for( long y=0, int x=0; y<6; y++) {
        // }

        // 2.
        // Can't use a comma in the conditional block of for loop
        // (Syntax error on token ",", . expected)
        // int j=8;
        // for( int i = 0; i<6, j>7; i++) {}

        // 3. 
        // while in do-while should have braces
        // boolean keepGoing = true;
        // int result = 15, meters = 10;
        // do{
        //     meters--;
        //     if(meters==8) keepGoing = false;
        //     result -= 2;
        // } while keepGoing;
        // System.out.println(result);

        // 4.
        // Normal brak logic
        var ostrich = new Character[]{'A', 'B', 'C'};
        var ostrich1 = new Character[]{'D', 'E', 'F'};
        L1: for( var emu : ostrich ) {
            System.out.println("outer " + emu);
            L2: for( var emu1: ostrich1 ) {
                System.out.println("Inner " + emu1);
                break L2;
            } 
        }

        // 5.
        // bad else and else if
        if(true) 
            System.out.println("hell");
        else 
            System.out.println("hell");
        // else if ( false )

        

    }
}
