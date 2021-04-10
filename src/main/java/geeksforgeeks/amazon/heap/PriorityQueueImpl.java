package geeksforgeeks.amazon.heap;

import java.util.Arrays;

public class PriorityQueueImpl {

    Heap heap;

    PriorityQueueImpl() {
        heap = new Heap();
    }

    public static void main(String[] args) {
        PriorityQueueImpl pi = new PriorityQueueImpl();
//        pi.add(100);
//        pi.add(2);
//        pi.add(3);
//        pi.add(10);
//        pi.add(6);
//        pi.add(5);
//        pi.add(7);
//        pi.add(8);
        pi.add(1);

        pi.display();
        System.out.println("size : " + pi.size());
        System.out.println("Is Empty: " + pi.isEmpty());


    }

    public boolean add(int data) {
        return heap.add(data);
    }

    public void display() {
        heap.printArray();
    }

    public int size() {
        return heap.size();
    }

    public int remove() {
        return heap.extractMin();
    }

    public boolean isEmpty() {
        int size = heap.size();
        if(size <=0){
            return true;
        }else {
            return false;
        }
    }
}


class Heap {
    static int capacity = 10;
    static int size = 0;
    int[] array;

    Heap() {
        array = new int[capacity];
    }

    public boolean add(int data) {

        if (capacity == size) {
            capacity *= 2;
            array = Arrays.copyOf(array, capacity);
        }
        if (size == 0) {
            array[size++] = data;
            return true;
        } else {
            array[size] = data;

            addHeapify();
            size++;
            return true;
        }
    }

    private void addHeapify() {
        int parentIndex = (size + 1) / 2 - 1;
        int childIndex = size;
        while (parentIndex >= 0 && array[parentIndex] > array[childIndex]) {
            swap(parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex + 1) / 2 - 1;
        }

    }


    public int extractMin() {
        if (size() <= 0) {
            return -1;
        } else {
            int temp = array[0];
            swap(0, size()-1);
            size--;
            heapify(0);
            return temp;
        }
    }

    private void heapify(int index) {

        int leftIndex = (index * 2) + 1;
        int rightIndex = (index * 2) + 2;

        int minIndex = index;

        if (leftIndex < size() && array[minIndex] > array[leftIndex]) {
            minIndex = leftIndex;
        }

        if (rightIndex < size() && array[minIndex] > array[rightIndex]) {
            minIndex = rightIndex;
        }

        if (minIndex != index) {
            swap(minIndex, index);
            heapify(minIndex);
        }

    }


    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int size() {
        return size;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
