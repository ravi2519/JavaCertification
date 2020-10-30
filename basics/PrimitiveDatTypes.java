
/**
 * PrimitiveDatTypes
 */
public class PrimitiveDatTypes {

    char instCh;
    long instLg;

    public static void main(String[] args) {
        
        // 1.
        // Below will give a compile error, beacuse the 
        // assigned value is a int and it is out of range
        // Compile time erro here
        // float fl = 32454322342;
        // Correct way
        float fl = 32454322342L;
        System.out.println(fl);

        // 2. 
        // valid short 
        short sh1 = 'a';
        System.out.println(sh1);
        
        // 3.
        // valid char
        char ch1 = (short)85;
        System.out.println(ch1);

        // 4.
        // invalid char ( compile time error )
        // char ch2 = -1;

        // 5.
        // You can add underscare anywhere except:
        // - beginning of the literal
        // - the end of literal
        // - right before the decimal point
        // - right after the decimal point
        // following are invalid
        // double notAtStart = _1000.00;
        // double notAtEnd = 1000.00_;
        // double notBeforeDec = 1000_.00;
        // double notAfterDec = 1000._00;

        // rest are valid
        int i1 = 100_00;
        short sh2 = 10_0;
        char ch2 = 1_0_0;
        long l1 = 2_00_000_000_000L;
        double ugly = 1___________________0; // prints 10.0

        System.out.println(i1);
        System.out.println(sh2);
        System.out.println(ch2);
        System.out.println(l1);
        System.out.println(ugly);

        // 6.
        // Invalid to assign null to primitive types
        // int i2 =null;
        String s1 = null;
        System.out.println(s1);

        // 7.
        // Identifies:
        // - must begin with a number, $ or _
        // - can have numbers but can't begin with them
        // - since Java9, underscore (_) is not a valid identifier
        // - can't have keywords
        // valid identifiers
        int $ = 1;
        System.out.println($);
        int $_ = 2;
        System.out.println($_);

        // 8.
        // Java adoesn't allow diclaring two different types in same statement
        // this is valid
        double d1 = 1, d2 = 2;
        System.out.println(d1);
        System.out.println(d2);
        
        // this is not valid
        // int i3 = 4, short sh2 = 3;

        // this too is not valid
        // int i4=4, int i5=5;

        // 9.
        // Uninitialized local variables will give compile time error only when we try to use them
        int uninitializedInt;
        // compile time in below statement
        // System.out.println(uninitializedInt);

        // 10.
        // var can not be initialized with a different type
        var v1 = 2; // v1 is pf type int now
        // below will be compile time error
        // v1 = "some";

        var apples = (short)10;
        apples = (byte)5; // this is valid since byte gets promoted to short
        // this is not valid
        // apples = 1_00_000_0000_0000;

        // 11. 
        // var must be initialized in same line
        // compile time error on below line
        // var sameline;
        // sameline = 0;

        // 12. 
        // Java doesn't allow var in multiple declarations
        // this is invalid ('var' is not allowed in a compound declaration)
        // var v2 = 2, v3 = 3;

        // 13. 
        // var ca't be initialized with null 
        // (Cannot infer type for local variable initialized to 'null')
        // var nullVal = null;

        // 14.
        // Can't assign float or double to int
        // (Type mismatch: cannot convert from double to int)
        // int i7 = 2.0;
        // (Type mismatch: cannot convert from long to int)
        // int i7 = 9L;

        // 15.
        // instance char defaults to blank
        System.out.println(new PrimitiveDatTypes().instCh);

        // instance long defaults to 0L
        System.out.println(new PrimitiveDatTypes().instLg);

        // 16.
        // a number with a decimal is always of type double.
        // we we assign such a decimal number to float then we
        // need to suffix that number with 'f/F'.
        // (Type mismatch: cannot convert from double to float)
        // float f2 = 2.1;
        // valid statement
        float f2 = 2.1F;
    }
    
}