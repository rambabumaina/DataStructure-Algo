package java8.lambda;

import java8.functionalInterface.MyFunctionalInterface;

public class MyLambda {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {

        // One Way using Anonymous inner class
        MyFunctionalInterface inter = new MyFunctionalInterface() {
            @Override
            public void myMethod() {
                System.out.println("Test");
            }
        };
        inter.myMethod();

        // Another Way using Lambda Expression
        MyFunctionalInterface lambda = () -> {
            System.out.println("Lambda");
        };

        lambda.myMethod();


        //Short Array using lambda
    }
}
