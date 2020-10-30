
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class JavaExceptions {

    // 3.
    // ExceptionInInitializerError
    // An ArrayIndexOutOfBoundsException in intializer block will
    // throw this exception
    static {
        int[] counts = new int[3];
        // UNCOMMENT BELOW CODE
        // System.out.println(counts[-1]);
    }
    
    public static void main(String[] args) throws IOException {
        
        // 1.
        // Nothing like negative index for Java Arrays
        // Following code throws a ArrayOutOfBoundsException
        int[] counts = new int[3];
        // UNCOMMENT BELOW CODE
        // System.out.println(counts[-1]);

        // 2.
        // Here ClassCastException occurs when we try to cast objects from
        // different types
        String type = "moose";
        Object obj = type;
        // UNCOMMENT BELOW CODE
        // Integer num = (Integer)obj;

        // 4.
        // Subtype excetion should not be after the parent exception
        // here second catch causes compiletime error
        try {
            throw new NumberFormatException();    
        } catch (IllegalArgumentException e) {} 
        // UNCOMMENET BELOW CODE
        // catch (NumberFormatException e){}

        // 5.
        // multi-catch block
        try{

        } catch( ArithmeticException | NullPointerException e) {

        }

        // 6.
        // multi-catch is for unrelated types
        // related types will result in compile time error
        // (The exception FileNotFoundException is already caught by the alternative IOException)
        // UNCOMMENT BELOW CODE
        // try{

        // } catch( FileNotFoundException | IOException e) {}

        // 7.
        // with finally block there can be return statements, but finally 
        // will always be called
        System.out.println(new JavaExceptions().gotHome());

        // 8.
        // try with resources can replace finally.
        // they help to close the resources that were declared in try
        try ( FileInputStream fi = new FileInputStream("Exceptions.txt") ) {

        } catch ( IOException e ) {
            e.printStackTrace();
        }

        // 9.
        // Catch block is optional with try with resources
        try( FileInputStream is = new FileInputStream("file") ) {

        }

        // 10.
        // finally is options with try with resources
        try( FileInputStream is = new FileInputStream("file")) {

        } finally {
            System.out.println("Finally is called");
        }

        // 11. 
        // Scope of variable declared in try with resources is inside 
        // the try block only
        //
        try( Scanner sc = new Scanner(System.in)) {
        } catch ( Exception e ) {
            // UNCOMMENT BELOW CODE
            // sc.nextInt();
        } finally {
            // UNCOMMENT BELOW CODE
            // sc.nextInt();
        }

        // 12.
        // If we place try-catch around methods that won't throw checked
        // exception, a compile time error will be thrown
        // (Unreachable catch block for IOException. This exception is never thrown from the try statement body)
        // try{
        //     new JavaExceptions().gotHome();
        // } catch ( IOException e ) {

        // }


    }

    public int gotHome() {
        try {
            System.out.print("1");
            // return -1;
            throw new Exception();
        } catch ( Exception e ) {
            System.out.print("2");
            return -2;
        } finally {
            System.out.println("3");
            return -3;
        }
    }

}
