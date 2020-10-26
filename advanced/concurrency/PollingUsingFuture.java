import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PollingUsingFuture {

    private static int counter = 0;

    public static void main(String[] args) throws Exception {
        
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();

            Future<?> result  = service.submit(() -> { for( long i = 0; i< 500000; i++ ) PollingUsingFuture.counter++; } );

            result.get( 10, TimeUnit.SECONDS );

            System.out.println("Reached!");
        } catch( TimeoutException te ) {
            System.out.println("Not reached in Time");
        } finally {
            if( service != null ) service.shutdown();
        }

    }
    
}
