package streams;

import java.util.List;

public class StreamNoTerminalOperation {
    
    public static void main(String[] args) {
        
        // Nothing is printed since we don't have any terminal operation in this stream.
        List.of(1, 2).stream().peek(System.out::println).limit(1);

    }

}
