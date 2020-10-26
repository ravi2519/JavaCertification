import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutor {
    
    public static void main(String[] args) {
        
        ScheduledExecutorService service = null;

        try {

            System.out.println("Begin");

            service = Executors.newSingleThreadScheduledExecutor();
            Runnable task1 = () -> System.out.println( " Runnable Task ");
            Callable<String> task2 = () -> { System.out.println(" Callable Task" ); return ""; };

            service.schedule( task1, 10, TimeUnit.SECONDS );
            service.schedule( task2, 5, TimeUnit.SECONDS );

            System.out.println("Done?");
        } finally {

            if( service != null ) service.shutdown();
        }

        // Result will be:
        // Begin
        // Done
        // Callable Task
        // Runnable Task


    }

}
