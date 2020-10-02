package basics;

public class JavaString {
    
    public static void main(String[] args) {
        
        // 1.
        // == doesnot works wth String and StringBuilder
        String string = "a";
        StringBuilder builder = new StringBuilder("a");
        // Incorrect ( Incompatible operand types String and StringBuilder )
        // System.out.println(string  == builder );
        // correct
        System.out.println(string  == builder.toString() ); // false

        // 2.
        // String evaluated in runtime are not equal
        String s1 = "Hello";
        String s2 = " Hello ".trim();
        System.out.println(s1 == s2 ); // false

        // 3.
        // String created using new are also not equal
        String s3 = new String("Hello");
        System.out.println(s1 == s3 ); // false

        // 4. 
        // String using intern might be nice ending
        String s4 = "Hello   ".stripTrailing().intern();
        System.out.println( s1 == s4); // true

        // 5.
        // + is considered as compile time
        String s5 = "He" + "ll" + "o";
        System.out.println( s1 == s5); // true

    }
}
