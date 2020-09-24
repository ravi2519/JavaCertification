package streams;

import java.util.stream.Stream;

public class StreamReduce {

    public static void main(String[] args) {
        Data data1 = new Data(1);
        Data data2 = new Data(2);

        // COmpilation error!!!!
        // The method reduce(Data, BinaryOperator<Data>) in the type Stream<Data> is not applicable for the arguments (int, (<no type> d1, <no type> d2) -> {})
        //Object result = Stream.of(data1, data2).reduce(1, (d1, d2) -> d1.number + d2.number);
        

        // Right way is this
        // reduce accepts identity and accumulator
        // accumulator is the the BinaryOperator 
        // The type of Idenity and BinraryOperator should be same.
        // The accumulator should also return same data type
        Data result = Stream.of(data1, data2).reduce(new Data(1), (Data a, Data b) -> new Data(a.number + b.number));

        System.out.println(result.number);
    }


}

class Data {
    int number;

    Data(int number) {
        this.number = number;
    }
}
