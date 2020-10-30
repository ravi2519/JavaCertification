
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

        // 6.
        // final and string
        // i2 being type Integer won't let str2 get stored in 
        // string pool
        final int i1 = 1;
        final Integer i2 = 1;
        final String st1 = ":ONE";
        
        String str1 = i1 + st1;
        String str2 = i2 + st1;
        
        System.out.println(str1 == "1:ONE"); // true
        System.out.println(str2 == "1:ONE"); // false

        String numbers = "012345678";
        System.out.println(numbers.substring(1, 3));
        System.out.println(numbers.substring(7, 7));
        System.out.println(numbers.substring(7));
    }
}
