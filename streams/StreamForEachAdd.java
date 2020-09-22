package streams;

import java.util.ArrayList;
import java.util.List;

public class StreamForEachAdd {

    public static void main(String[] args) {

        // Exception in thread "main" java.util.ConcurrentModificationException
        
        List<Integer> input = List.of(1);
        List<Integer> list = new ArrayList<>(input);
        list.stream().forEach(i -> list.add(i + 1));
        System.out.println(list);

    }

}
