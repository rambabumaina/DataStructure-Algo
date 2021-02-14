package amazon.arrays;

import java.util.Arrays;

public class KLargestElement {

    public static void main(String[] args) {
        int [] arr = {1, 23, 12, 9, 30, 2, 50};
        int k =3;
        Heap heap = new Heap(k);

        for (int i = 0 ; i< k; i++){
            heap.arr[i] = arr[i];
        }

        heap.buildHeap();
        for (int i = k ; i< arr.length; i++){
            if(heap.arr[0] < arr[i]){
                heap.arr[0] = arr[i];
                heap.heapify(0,heap.size);
            }
        }
        Arrays.stream(heap.arr).forEach(s-> System.out.print(s + " "));
    }


    static class Heap{

        int[] arr;
        int size;

        Heap(int size){
            this.size = size;
            this.arr = new int[size];
        }

        public void buildHeap(){
            int index = (size/2)-1;
            for (int i = index ; i>=0; i-- ){
                heapify(i, size);
            }
        }

        public void heapify(int index, int size){

            int leftChild = index*2+1;
            int rightChild = index*2+2;

            int minIndex=index;

            if(leftChild < size && arr[minIndex] > arr[leftChild]){
                minIndex = leftChild;
            }

            if(rightChild < size && arr[minIndex] > arr[rightChild]){
                minIndex = rightChild;
            }

            if(minIndex != index){
                int temp = arr[minIndex];
                arr[minIndex] = arr[index];
                arr[index] = temp;

                heapify(minIndex, size);
            }
        }
    }
}
