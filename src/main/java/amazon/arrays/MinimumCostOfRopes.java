package amazon.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        long [] arr = {3,2,4,6};
        MinimumCostOfRopes m = new MinimumCostOfRopes();
        System.out.println(m.minCost(arr, arr.length));

    }

    long minCost(long [] arr, int n) {
        PriorityQueue<Long> p = new PriorityQueue<>();
        Arrays.stream(arr).forEach(p::add);
        if (n == 1) {
            return 0;
        }
        long maxCost=0;
        long add = 0;
        while (!p.isEmpty()) {
            Long l1 = p.poll();
            Long l2 = p.poll();
            add = l1+l2;
            maxCost += add;
            if(p.isEmpty()){
                break;
            }
            p.add(add);
        }
        return maxCost;
    }


//    private long minCostUsingHeap(long [] arr, int n){
//
//    }
//
//    private void buildMinHeap(long [] arr, int n){
//        int firstNonLeafNode = (arr.length/2)-1;
//        for (int i = 0 ; i> firstNonLeafNode; i--){
//            notify();
//        }
//    }
//
//    private void heapify() {
//
//    }



}
