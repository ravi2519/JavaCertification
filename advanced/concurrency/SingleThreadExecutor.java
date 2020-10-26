import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    

    public static void main(String[] args) {
        
        ExecutorService service = null;
        Runnable task1 = () -> System.out.println("Performing Task 1");
        Runnable task2 = () -> { for(int i=0; i<3; i++ ) System.out.println("Performing Task 2 for " + i ); };

        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");

            // with the single thread executor the tasks will run sequentially
            service.execute(task1);
            service.execute(task2);
            service.execute(task1);
            
            System.out.println("End");
        } finally {
            // If not shutdown then the application may never terminates on its own.
            if( service != null ) service.shutdown();
        }

    }

}
