import java.io.IOException;

public class JavaException {
    public static void main(String[] args) {

        
        int x = 10, y = 20;
        int dx, dy;
        try{
            dx = x % 5;
            dy =  y/dx;
        }catch(ArithmeticException ae){
            System.out.println("Caught AE");
            dx = 2;
            dy = y/dx;
        }
        x = x/dx;
        y = y/dy;
        System.out.println(dx+" "+dy);
        System.out.println(x+" "+y);
        
        // 1.
        // No matter what happens, the exception raised by
        // finally will get through
        try (MyResource myResource = new MyResource()) {
            myResource.open();
            throw new NullPointerException("try");
        } catch (Exception e) {
            throw new IllegalArgumentException("catch");
        } finally {
            throw new ClassCastException("finally");
        }


    }
}

class MyResource implements AutoCloseable {
    public void open() throws IOException {
        throw new IOException("open");
    }

    public void close() {
        throw new ArithmeticException("close");
    }
}
