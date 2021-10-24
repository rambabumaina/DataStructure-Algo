package demo;

public class SumOfPrime {

    public static void main(String[] args) {
        int [] input = {1,2,3,4,5};
        int n = 5;
        sumOfPrime(input, n);

    }

    private static void sumOfPrime(int[] input, int n) {

        int i = 0;
        int sum=0;
        while (i< n){
            int num =input[i];
            if(isNmberPrime(num)){
                sum +=num;
            }
            i++;
        }
        System.out.println(sum);
    }

    private static boolean isNmberPrime(int num) {
        if (num < 2){
            return false;
        }
        for (int i =2 ; i <= Math.sqrt(num) ;i++){
            if(num%i ==0){
                return false;
            }
        }
        return true;
    }


}
