package java8.functionalInterface;

public class Test {
    public static void main(String[] args) {
        MyInterface m = x->x*2;


        System.out.println(m.calculate(10));
    }
}
