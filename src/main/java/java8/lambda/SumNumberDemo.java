package java8.lambda;

import java8.functionalInterface.SumNumber;

public class SumNumberDemo {

    static int x =1;

    public static void main(String[] args) {

         SumNumber<Integer> sum = (Integer a, Integer b) -> {
            x = x+3;
            return a + b+ x;
        };

        Integer result = sum.sumMethod(2, 3);
        System.out.println(result);

    }
}
