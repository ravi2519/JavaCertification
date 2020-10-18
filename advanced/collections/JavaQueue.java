
import java.util.LinkedList;
import java.util.Queue;

import javax.management.QueryEval;

public class JavaQueue {
    
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // 1.
        // E element()
        // Returns next element or throws an exception if empty 
        // queue
        // System.out.println(queue.element()); // NoSuchElementException
        queue.add( 10 );
        System.out.println(queue.element()); // 10
        System.out.println(queue.element()); // 10
        
        // 2.
        // boolean add(E e)
        // Adds an element to the back of the queue and 
        // return true or throws an exception
        System.out.println( queue.add( 20 ) ); // true

        // 3.
        // boolean offer(E e)
        // Adds an element to the back of the queu and 
        // returns whether successful
        System.out.println( queue.offer(30) );
        System.out.println( queue.offer(40) );
        
        // 4.
        // E remove()
        // Remove an elemnt from the beginning of the queue.
        System.out.println( queue.remove() ); // 10
        System.out.println( queue.remove() ); // 20

        // 5.
        // E poll()
        // Removes and returns next element or returns null if
        // empty queue
        Integer pollRet = queue.poll();
        System.out.println( pollRet ); // 30
        System.out.println( queue.poll() ); // 40
        
        // 6
        // E peek()
        //  Returns next elment or returns null if empty queue
        System.out.println( queue.offer(50) );
        System.out.println( queue.peek() ); // 50
        System.out.println( queue.peek() ); // null

        // 7
        // offer, poll and peek doesn't throw an exception

    }

}
