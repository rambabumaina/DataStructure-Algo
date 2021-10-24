package leetcode.arrays;

public class BestTime_Buy_Sell_Stock {

    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7};

        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int i = 0, j = i + 1, sum = 0;

        if(prices.length < 2){
            return sum;
        }

        while (j < prices.length) {
            if(prices[i] < prices[j]){
               sum += prices[j]-prices[i];
            }
            i++;
            j++;
        }

        return sum;
    }
}
