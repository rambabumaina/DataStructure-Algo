package java8.functionalInterface;

@FunctionalInterface
public interface MyFunctionalInterface {
    public abstract void myMethod();

    default void defaultMethod() {}
    static void staticMethod() {}
}
