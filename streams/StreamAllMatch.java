package streams;

import java.util.Arrays;
import java.util.List;

public class StreamAllMatch {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, 4, 6, 7, 8);
        boolean allEven = list.stream().allMatch(i -> {
            System.out.print(i);
            return i % 2 == 0;
        });

    }

}
