import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRate {
    
    public static void main(String[] args) {
        
        ScheduledExecutorService service = null;
        
        try {

            System.out.println("Begin");

            service = Executors.newSingleThreadScheduledExecutor();
            Runnable task1 = () -> System.out.println( " Runnable Task ");
            
            service.scheduleAtFixedRate(task1, 5, 1, TimeUnit.SECONDS);

            System.out.println("Done?");
        } finally {
            // Shutdown should not happen here
            // if( service != null ) service.shutdown();

            System.out.println("Finally");
        }

        // Results are:
        // Begin
        // Done?
        // Finally
        // Runnable Task
        // Runnable Task
        // Runnable Task
        // .
        // .

    }

}
