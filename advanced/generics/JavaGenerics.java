package advanced.generics;

import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {
    

    public static void main(String[] args) {
        
        // 1.
        // null can't be unboxed
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(null); // perfectlty fine
        int num = lst.get(1); // NullPointerException

        

    }

}
