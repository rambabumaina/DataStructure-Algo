package java8.functionalInterface;

@FunctionalInterface
public interface SumNumber<A> {

    A sumMethod( A val1 , A val2);
}
