package streams;

import java.util.stream.Stream;

public class StreamForEachAndPeek {

    public static void main(String[] args) {

        // Cannot invoke peek((<no type> i) -> {}) on the primitive type void

        // Stream.of(0, 1, 2, 3).forEach(
        //     i -> {
        //         if (i % 2 == 0)
        //             System.out.print(i);
        //     }
        // )
        // .peek(i -> {
        //     if (i % 2 != 0)
        //         System.out.print(i);
        // });

    }

}
