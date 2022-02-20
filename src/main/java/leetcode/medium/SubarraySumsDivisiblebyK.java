package leetcode.medium;

//https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubarraySumsDivisiblebyK {

    public static void main(String[] args) {
        int k = 5;
        //running sum:= 4,9,9,7,4,5
        int[] nums = {4, 5, 0, -2, -3, 1};
        //reminders   :4,4,4, 2, 4, 0

        System.out.println("Result :"+ subarraysDivByK(nums, k));
    }

    static int subarraysDivByK(int[] nums, int k) {
        // To keep the reminders, K size because reminders will never go beyond that
        int[] count = new int[k];
        int sum = 0;

        for (int n : nums) {
            //running reminder and handling negative case
            sum += (n % k + k) % k;

            //incrementing reminder count
            count[sum % k]++;
        }
        //0, 2, 1, 1 ,0, 1, 0
        //1:rem=1, sum=1
        //8:rem=1,sum=2
        //6:rem= 6,sum=8
        //4:rem=4,sum =12
        //5:rem=5,sum=17


//        Arrays.stream(count).forEach(System.out::println);
        // To handle 0 senario because (0/5=0) zero
        // case once: case of zero it will be c*(c-1)/2 + n
        // case two: for other cases (c*(c-1))/2;
        int result = count[0];

        for (int c : count) {
            result += (c * (c - 1)) / 2;
        }

        return result;
    }
}
