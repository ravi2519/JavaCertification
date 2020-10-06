package basics;

public class JavaInheritance {
    
}

// 1.
// A doesn't have a no argument constructor.
// So when B comes into picture, java will try
// to create a default constructor for B by itself.
// And then Java will try to call super().
// Since parent don't have any no-arg constructor
// this will end up with a compile time error.
class A {
    A(int n){}
}

class B extends A {
}


