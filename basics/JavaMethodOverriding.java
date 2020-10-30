
import java.util.List;

/**
 * JavaMethodOverriding
 */
public class JavaMethodOverriding {

    
}

// 1.
// Not a valid override
class AA {
    protected List<String> hairy(int p) { return null; }
}

class BB extends AA{
    // UNCOMMENT THE CODE
    // protected Object hairy(int p) { return null;}
}

// END OF 1