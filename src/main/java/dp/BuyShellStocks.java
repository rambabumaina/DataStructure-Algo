package dp;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/
public class BuyShellStocks {
    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(input));
    }


    static int maxProfit(int[] prices) {
        int MIN = Integer.MAX_VALUE;//7,1
        int MAXPROFIT = 0;//4,5

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < MIN) {
                MIN = prices[i];   ///This will set MIn
            } else if (prices[i] - MIN > MAXPROFIT) {
                MAXPROFIT = prices[i] - MIN;
            }
        }
        return MAXPROFIT;
    }

    // N^2 complexity
    static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j] && maxProfit < prices[j] - prices[i]) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }

        return maxProfit;
    }
}
