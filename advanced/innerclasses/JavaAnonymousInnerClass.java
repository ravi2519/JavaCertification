
public class JavaAnonymousInnerClass {

    abstract class NormalInnerClass {
        abstract void doSomething();
    }

    public class NormalInnerClassConst {
        int i;
        public NormalInnerClassConst(int i){
            this.i = i;
        }

        private void print() {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        JavaAnonymousInnerClass outerClassObj = new JavaAnonymousInnerClass();
        
        // 1. Anonymous class example
        NormalInnerClass obj = outerClassObj.new NormalInnerClass() {
            void doSomething() {
                System.out.println("Doing something");
            }
        };

        obj.doSomething();

        // 2.
        // Annonymous class calling constructore
        NormalInnerClassConst constobj = outerClassObj.new NormalInnerClassConst(20) {};
        constobj.print();

    }
    
}
