
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static int counter = 0;

    public static int incrCounter() {
        var rlock = new ReentrantLock();

        rlock.lock();
        counter++;
        rlock.unlock();

        return counter;
    }

    public static void main(String[] args) throws Exception {
        
        ExecutorService executor = null;

        try{
            executor = Executors.newFixedThreadPool(20);

            Callable<Integer> task1 = () -> ReentrantLockExample.incrCounter();
            Callable<Integer> task2 = () -> ReentrantLockExample.incrCounter();

            executor.invokeAll( List.of(task1, task2, task1, task2, task1, task2, task1, task2, task1, task2), 10, TimeUnit.SECONDS );

            System.out.println(ReentrantLockExample.counter);

        } finally {
            if( executor != null ) executor.shutdown();
        }
        
    }
    
}
