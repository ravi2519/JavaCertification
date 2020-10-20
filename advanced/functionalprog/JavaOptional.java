
import java.util.Optional;

public class JavaOptional {
    
    public static void main(String[] args) throws ClassNotFoundException {

        // Optional
        //  -   empty ( Optional.empty() )
        //  -   of  ( Optional.of( value ) )
        //  -   get ( o.get() )
        //  -   isPresent   ( o.isPresent() )
        //  -   ofNullable  ( Optional.ofNullable( o ) )
        //  -   ifPresent   ( o.ifPresent( consumer ) )
        //  -   orElse  ( o.orElse( T t) )
        //  -   orElseGet   ( o.orElseGet( supplier ) )
        //  -   orElseThrow ( o.orElseThrow() -> throws NoSuchElementException )
        //  -   orElseThrow ( o.orEleseThrow( Supplier ) )

        Optional<Double> empty = getAverage();
        Optional<Double> notEmpty = getAverage(1.2, 3.9, 4.0, 9.1);

        System.out.println( empty );
        System.out.println( notEmpty );

        // System.out.println( empty.get() ); // NoSuchElementException

        if( notEmpty.isPresent() ) System.out.println( notEmpty.get() );

        System.out.println( Optional.ofNullable(empty).get() );
        System.out.println( Optional.ofNullable(notEmpty).get() );

        notEmpty.ifPresent(System.out::println);
        System.out.println( empty.orElse( 0.0 ) );
        System.out.println( empty.orElseGet( () -> Double.NaN ) );

        empty.orElseThrow(ClassNotFoundException::new);
        
        

    }

    public static Optional<Double> getAverage( Double... dargs ) {

        if( dargs.length == 0 ) return Optional.empty();

        double res = 0;
        for( var d : dargs ) res += (double)d;
        res = res/dargs.length;

        return Optional.of( (Double) res );

    }

}
