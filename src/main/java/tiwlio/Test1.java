package tiwlio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

public class Test1 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(10000);
//        list.add(6);
        System.out.println("Max:" + segment(1, list));

    }

    public static int segment(int x, List<Integer> space) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < x; i++) {
            priorityQueue.add(space.get(i));
        }

        int max = 0;
        int index =0;
        for (int i = x; i < space.size(); i++) {

            int peek = priorityQueue.peek();

            System.out.println("peek:" + peek);
            priorityQueue.remove(space.get(index));

            priorityQueue.add(space.get(i));
            max = Math.max(max, peek);
            index++;
        }
        max = Math.max(max,priorityQueue.peek());
        return max;
    }
}
