import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaPath {

    public static void main(String[] args) {

        // 1.
        // Creating directory path using Path.of
        Path dir1 = Path.of("nio2", "dir1");
        System.out.println(dir1);
        System.out.println(dir1.toAbsolutePath());

        // 2.
        // Creating file path using Path.of
        Path file1 = Path.of("nio2", "dir1", "file1.txt");
        System.out.println(file1);
        System.out.println(file1.toAbsolutePath());
        System.out.println(file1.getFileName());

        // 3.
        // Creating directory path using Path.of
        Path dir2 = Paths.get("nio2", "dir1");
        System.out.println(dir2);
        System.out.println(dir2.toAbsolutePath());

        // 4.
        // Creating file path using Path.of
        Path file2 = Paths.get("nio2", "dir1", "file1.txt");
        System.out.println(file2);
        System.out.println(file2.toAbsolutePath());
        System.out.println(file2.getFileName());

        // 5.
        // Creating file path using URI and Paths.get
        Path file3;
        try {
            file3 = Paths.get(new URI("file://nio2/dir1/file1.txt"));
            System.out.println(file3);
            System.out.println( file3.toAbsolutePath() );
            System.out.println( file3.getFileName() );
            System.out.println( file3.getFileSystem() );
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // 6.
        // Creating file path using URI and Path.of
        Path file4;
        try {
            file4 = Path.of(new URI("file://nio2/dir1/file1.txt"));
            System.out.println(file4);
            System.out.println( file4.toAbsolutePath() );
            System.out.println( file4.getFileName() );
            System.out.println( file4.getFileSystem() );
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // 7.
        // Creating directory path using FileSystem
        Path dir3 = FileSystems.getDefault().getPath("nio2", "dir1");
        System.out.println(dir3);
        System.out.println(dir3.toAbsolutePath());

        // 8.
        // Creating file path using FileSystem
        Path file5 = FileSystems.getDefault().getPath("nio2", "dir1", "file1.txt");
        System.out.println(file5);
        System.out.println(file5.toAbsolutePath());
        System.out.println(file5.getFileName());

        // 9.
        // Creating File to Path
        Path file6 = new File( "nio2", "dir1\\file1.txt").toPath();
        System.out.println(file6);
        System.out.println(file6.toAbsolutePath());
        System.out.println(file6.getFileName());

        // 10.
        // Creating Path to File
        File file7 = Paths.get("nio2", "dir1", "file1.txt").toFile();
        System.out.println(file7);
        System.out.println(file7.getAbsolutePath());
        System.out.println(file7.getName());

    }
}
