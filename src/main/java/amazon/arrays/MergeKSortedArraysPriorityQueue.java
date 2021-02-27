package amazon.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArraysPriorityQueue {
    public static void main(String[] args) {
    int arr[][] = {

            {1,2,3,4},//(0,1)
            {2,2,3,4},
            {5,5,6,6},
            {7,8,9,9}
    };

        ArrayList<Integer> list = mergeKArraysUsingPriorityQueue(arr, arr.length);
        System.out.println(list);
    }

    public static ArrayList<Integer> mergeKArraysUsingPriorityQueue(int[][] arrays, int k)
    {
        PriorityQueue<Node> p = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0 ; i< arrays.length; i++){
            p.add(new Node(i,0,arrays[i][0]));
        }

        while (!p.isEmpty()){
            Node poll = p.poll();
            list.add(poll.value);
            if(poll.j+1 < arrays[0].length){
                p.add(new Node(poll.i,poll.j+1,arrays[poll.i][poll.j+1]));
            }
        }
        return list;
    }

    static class Node {
        int i;
        int j;
        int value;

        public Node(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
