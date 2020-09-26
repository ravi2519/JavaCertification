package streams.collisions;

// NOT A FI
//@FunctionalInterface
interface fi1 {
    int hashCode();
}

// NOT A FI
// @FunctionalInterface
interface fi2 {
    boolean equals(Object obj);
}

// VALID FI
// Since clone has return type of protected and here it is 
// public then this is not a overriding and thus a valid
// public abstract
@FunctionalInterface
interface fi3 {
    Object clone();
}

// VALID FI
// Object class getClass is like this:
// public final Class<?> getClass()
// i.e. not overridable.
// We can thus add and argument this method 
// which makes the compiler happy and a valid
// pubilc abstract and thus FI
@FunctionalInterface
interface fi4 {
    Class<?> getClass(Object obj);
}

// NOT A VALID FI
// @FunctionalInterface
interface fi5 {
    String toString();
}

// VALID FI
// notify has this forms in Object class:
// public final void notify()
// below one is a valid public abstract
@FunctionalInterface
interface fi6 {
    void notify(String s);
}

// VALID FI
// notifyAll has this forms in Object class:
// public final void notifyAll()
// below one is a valid public abstract
@FunctionalInterface
interface fi7 {
    void notifyAll(String s);
}

// VALID FI
// wait has these forms in Object class:
// - public final void wait(long timeout)
//                              throws InterruptedException
// - public final void wait(long timeout,
//                          int nanos)
//                              throws InterruptedException
// - public final void wait() throws InterruptedException
// below one is a valid public abstract
@FunctionalInterface
interface fi8 {
    void wait(String s);
}

// VALID FI
// Since finalize has return type of protected and here it is 
// public then this is not a overriding and thus a valid
// public abstract
@FunctionalInterface
interface fi9 extends fi5{
    void finalize();
}

// VALID FI
@FunctionalInterface
interface fi10 extends fi9 {
}


public class FunctionalInterfaces {
    
}
