package advanced.innerclasses;

public class JavaStaticInnerClass {
    
    // 1. Static inner class can be private
    private static class PrivateStaticInnerClass {}

    // 2. Static inner class can be public as well
    public static class PublicStaticInnerClass {}

    // 3. Static inner class can be a protected as well
    protected static class ProtectedStaticInnerClass {}

    // 4. Static inner class can be a package private /default as well
    static class DefaultStaticInnerClass {
        private int var = 10;
    }

    public static void main(String[] args) {

        // 5. Static inner class can be initiated without the enclosing class object
        DefaultStaticInnerClass staticClassObj = new DefaultStaticInnerClass();
        System.out.println(staticClassObj.var);
    }


}
