package amazon.queue;

import java.util.Scanner;

public class QueueImp {

    int[] arr = null;
    int size = 0 ;
    int capacity =0;
    int front= -1;
    int rear= -1;

    QueueImp(int incapacity) {
        capacity =incapacity;
        arr = new int[incapacity];
    }

    boolean enqueue(int e) {

        if (size == capacity) {
            System.out.println("queue over flow");
            return false;
        }

        if (rear == -1) {
            rear = front = 0;
            arr[rear] = e;
        } else {
            rear++;
            rear = rear%capacity;
            arr[rear] = e;
        }

        System.out.println("Front:"+front+" Rear: "+ rear);
        size++;
        return true;
    }

    void deQueue() {
        if(front == -1){
            System.out.println("queue under flow");
            return;
        }

        int temp = arr[front];
        front++;
        front = front%capacity;
        size --;

        if(size == 0 ){
            front = rear = -1;
        }
        System.out.println("Front:"+front+" Rear: "+ rear);
    }

    void print(){
        if(size > 0) {
            if(front > rear){
                for (int i = front; i < capacity; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();

            }
            else{
                for (int i = front ; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueImp q = new QueueImp(5);

      while(true){
          int op = sc.nextInt();
          switch (op){
              case 0:
                  q.deQueue();
                  q.print();
                  break;
              case 1:
                  System.out.print("Enter element to add in queue: ");
                  q.enqueue(sc.nextInt());
                  q.print();
                  break;
          }
      }

    }


}
