package tiwlio;

public class MaximumProfit {

    public static void main(String[] args) {

        int arr[] = {10, 8, 6, 4, 2, 11, 6, 2, 10};

        getMaxProfit(arr);
    }

    public static void getMaxProfit(int[] arr) {
        int maxProfit = 0; //4
        int currentMax = 0; //4
        int start = 0; //4
        int startDay = 0;  //4
        int endDay = 0; // 6
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[i - 1]) {
                currentMax = currentMax + arr[i] - arr[i - 1];

                if (maxProfit < currentMax) {
                    maxProfit = currentMax;
                    startDay = start;
                    endDay = i;
                }
            } else {
                currentMax = 0;
                start = i;
            }

        }
        System.out.println("Max: "+ maxProfit);
        System.out.println("start: " + startDay + " end: " + endDay);

    }
}
