import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaPathUtilities {
    
    public static void main(String[] args) {
        
        // 1.
        // getNameCount and getName
        Path path1 = Paths.get("/usr/home/ravi");
        System.out.println("Path is " + path1);

        for ( int i = 0; i < path1.getNameCount(); i++ ) {
            System.out.println("At " + i + " we have " + path1.getName(i));
        }

        var path2 = Paths.get("/");
        System.out.println("Path is " + path2); // \
        System.out.println("Name count is " + path2.getNameCount()); // 0
        // System.out.println("Name at 0 is " + path2.getName(0)); // Exception in thread "main" java.lang.IllegalArgumentException

        // 2.
        // subpath
        System.out.println(path1.subpath(0, 3)); // usr\home\ravi
        System.out.println(path1.subpath(1, 2)); // home
        System.out.println(path1.subpath(1, 3)); // home\ravi
        // System.out.println(path1.subpath(2, 4)); // Exception in thread "main" java.lang.IllegalArgumentException
        // System.out.println(path1.subpath(1, 1)); // Exception in thread "main" java.lang.IllegalArgumentException

        // 3.
        // getParent, getRoot
        System.out.println("======= getParent ===============");
        Path currentPath = path1;
        while( ( currentPath = currentPath.getParent() ) != null ) {
            System.out.println(currentPath);
        }
        System.out.println("=========================");
        
        System.out.println("======= getRoot ===============");
        System.out.println( path1.getRoot() );
        System.out.println("========================");
        
        Path path3 = Paths.get("moon");
        System.out.println( path3.getParent() ); //null
        System.out.println( path3.getRoot() ); // null

        Path path4 = Paths.get("/moon/../earth/./venus");
        System.out.println("======= getParent ===============");
        currentPath = path4;
        while( ( currentPath = currentPath.getParent() ) != null ) {
            System.out.println(currentPath);
        }
        System.out.println("=========================");

        // 4.
        // relativize when paths are relative
        Path path5 = Paths.get("file.txt");
        Path path6 = Paths.get("some", "path", "to", "fil2.txt");
        System.out.println(path5.relativize(path6));  // ..\some\path\to\fil2.txt
        System.out.println(path6.relativize(path5)); // ..\..\..\..\file.txt
        System.out.println(path6.relativize(path6)); // blank

        // relativize when paths are absolute
        path5 = Paths.get("d:\\here", "is", "file.txt");
        path6 = Paths.get("d:\\some", "path", "to", "fil2.txt");
        System.out.println(path5.relativize(path6));  // ..\..\..\some\path\to\fil2.txt
        System.out.println(path6.relativize(path5)); // ..\..\..\..\here\is\file.txt
        System.out.println(path6.relativize(path6)); // blank

        // whnen paths are mixed
        path5 = Paths.get("file.txt");
        path6 = Paths.get("d:\\some", "path", "to", "fil2.txt");
        // System.out.println(path5.relativize(path6));  // Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path
        // System.out.println(path6.relativize(path5)); // Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path

         // whnen paths are absolute from different roots
         path5 = Paths.get("c:\\file.txt");
         path6 = Paths.get("d:\\some", "path", "to", "fil2.txt");
        //  System.out.println(path5.relativize(path6));  // Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path
        //  System.out.println(path6.relativize(path5)); // Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path




    }
}
