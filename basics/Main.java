
import java.util.ArrayList;
import java.util.List;
 
public class Main {
    public final static void main(String[] args) {
        List<String> list = new ArrayList<>(4);
        list.add(0, "MOVE");
        list.add(2, "ON");
        System.out.println( list );

        // i is not out of maximum int range yet
        int i = 1234567890;
        float f = i;
        System.out.println(i - (int) f);

        // Its perfectly ok to have a variable name after the name of a class
        String String = "is this valid?";
        int Exception = 0;
        long Error = 20; 
        
        // System.out.println(list);
    }
}

// public class Main {
//     public static void main(String[] args) {

//     }
// }


/* 
// true
// false
public class Main {
    public static void main(String[] args) {
        final int i1 = 1;
        final Integer i2 = 1;
        final String s1 = ":ONE";
        
        String str1 = i1 + s1;
        String str2 = i2 + s1;
        
        System.out.println(str1 == "1:ONE");
        System.out.println(str2 == "1:ONE");
    }
} */


/* 
// false
public class Main {
    public static void main(String[] args) {
        String javaworld = "JavaWorld";
        String java = "Java";
        String world = "World";
        java += world;
        System.out.println(java == javaworld);
    }
} */

/* // MITS
public class Main {
    public static void main(String[] args) {
      String place = "MISSS";
      System.out.println(place.replace("SS", "T"));
    }
} */

/* // false
// true
public class Main {
    public static void main(String[] args) {
        final String fName = "James";
        String lName = "Gosling";
        String name1 = fName + lName;
        String name2 = fName + "Gosling";
        String name3 = "James" + "Gosling";
        System.out.println(name1 == name2);
        System.out.println(name2 == name3);
    }
} */

/* // Main.java:2: error: cannot inherit from final String
// public class Main extends String {
//                           ^
// 1 error
// compiler exit status 1

public class Main extends String {
    @Override
    public String toString() {
        return "TEST";
    }
    
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj);
    }
} */


/* // Following will print 25
public class Main {
    public static void main(String [] args) {
      var x = 7.85; //Line n1
      var y = 5.25f; //Line n2
      var a = (int)x + (int)y; //Line n3
      var b = (int)(x + y); //Line n4
      System.out.println(a + b);
    }
} */

/* // Following will print 20
public class Main {
    public static void main(String [] args) {
      final var x = 10; //Line n1
        byte b = x + 10; //Line n2
        System.out.println(b);
    }
} */


/* // Following doesn't compile
// - public main() doesn't have a return type
// - overloading with just static is not supported

public class Main {
    static String Main = "ONE";
    
    public Main() {
        System.out.println("TWO");
    }
    
    public static void Main(String [] args) {
        Main();
    }
    
    public static void Main() {
        System.out.println(Main);
    }
} */



/* //Following will throw a runtime exception
//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 1 out of //bounds for length 0
//    at Message.main(Main.java:30)
//    at Main.main(Main.java:36)
class Message {
    public static void main(String [] args) {
        System.out.println("Welcome! " + args[1]);
    }
}
 
public class Main {
    public static void main(String [] args) {
        Message.main(args);
    }
} */



/* //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 1 out of //bounds for length 0
//    at Message.main(Main.java:36)
//    at Main.main(Main.java:42)
//exit status 1

class Message {
    static void main(String [] args) {
        System.out.println("Welcome! " + args[1]);
    }
}
 
public class Main {
    public static void main(String [] args) {
        Message.main(args);
    }
} */

/* 
// Public classes should be in seprate files

// > javac -classpath .:/run_dir/junit-4.12.jar:target/dependency/* -d . Main.java MainDefn.java
// Main.java:73: error: class B is public, should be declared in a file named B.java
// public class B {
//  ^
// Main.java:79: error: class C is public, should be declared in a file named C.java
// public class C {
      //  ^
// Main.java:85: error: class D is public, should be declared in a file named D.java
// public class D {
      //  ^
// 3 errors
// compiler exit status 1
public class Main {
     public static void main(String [] args) {
        System.out.print("A");
    }
}
 
public class B {
    public static void main(String... args) {
        System.out.print("B");
    }
}
 
public class C {
    public static void main(Object... args) {
        System.out.print("C");
    }
}
 
public class D {
    public static void main(String a) {
        System.out.print("D");
    }
} */

/* 
// This works fine and will print "Parent"
class Main {
    public static void main(String [] args) {
        System.out.println("Parent");
    }
}
 
class Child extends Main {
    public static void main(String [] args) {
        System.out.println("Child");
    }
} */

