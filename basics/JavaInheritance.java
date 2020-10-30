
// 1.
// A doesn't have a no argument constructor.
// So when B comes into picture, java will try
// to create a default constructor for B by itself.
// And then Java will try to call super().
// Since parent don't have any no-arg constructor
// this will end up with a compile time error.
class A {
    A(int n){}

    void m1 () {
        System.out.println("Parent A");
    }
}

// UNCOMMENT BELOW
// class B extends A {
// }

// END OF 1

// 2.
// Adding a final to a overriding method is still valid
class C extends A {
    C(int n){
        super(n);
    }

    public final void m1() { // <=== NO PROBLEM HERE
        System.out.println("Child C");
    }
}

// END OF 2

// 3.
// A doesn't have a no argument constructor.
// So in class D, Java will add a call to super()
// as the first statement to the no argument 
// constructor. This will fail
// UNCOMMENT BELOW
// class D extends A {
//     D(){}
// }

// END OF 3

// 4.
// A doesn't have a no argument constructor.
// So in class E, Java will add a call to super()
// as the first statement to the single argument 
// constructor. This will fail.
// TO correct this we can add a call to super(n)
// UNCOMMENT BELOW
// class E extends A {
//     E(int n){System.out.println("E");}
// }

// END OF 4

public class JavaInheritance {

    public static void main(String[] args) {
        
        System.out.println("-----------------------2-----------------");
        A a = new C(1);
        a.m1();
        System.out.println("-----------------------2-----------------");

    }
}





    
