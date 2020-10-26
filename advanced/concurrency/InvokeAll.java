import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAll {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ExecutorService service = null;

        try {
            System.out.println( "Begin" );
            service = Executors.newSingleThreadExecutor();
            Callable<String> task = () -> "result";
            List<Future<String>> resList = service.invokeAll(List.of( task, task, task, task ));

            for( var res : resList ) {
                System.out.println( res.get() );
            }

            System.out.println("End");
        } finally {
            if( service != null ) service.shutdown();
        }

    }
}
