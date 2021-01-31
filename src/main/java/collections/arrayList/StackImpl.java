package collections.arrayList;


import java.util.Arrays;
import java.util.Stack;

public class StackImpl<E> {
    Object[] obj;
    int INITIAL_CAPACITY = 5;
    int CURRENT_CAPACITY = INITIAL_CAPACITY;
    int SIZE = 0;

    public StackImpl() {
        obj = new Object[INITIAL_CAPACITY];
    }

    public void push(E e) {
        if (SIZE == CURRENT_CAPACITY) {
            ensureCapacity();
        }
        obj[SIZE++] = e;
    }

    public Object pop() {
        if (SIZE > 0) {
            Object o = obj[--SIZE];
            return o;
        } else {
            throw new RuntimeException("Empty stack Exception..");
        }
    }

    Object peek(){
        if(SIZE <=0){
            throw new RuntimeException("Empty stack Exception..");
        }else {
            return obj[--SIZE];
        }
    }

    private void ensureCapacity(){
        CURRENT_CAPACITY *= 2;
        obj = Arrays.copyOf(obj, CURRENT_CAPACITY);
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        StackImpl impl = new StackImpl();
        impl.push("1");
        impl.push("2");
        impl.push("3");
        impl.push("4");


        System.out.println("Size:" + impl.SIZE);

        impl.pop();
        impl.pop();
        impl.pop();
        impl.pop();


        System.out.println("Size: " + impl.SIZE);
        System.out.println("PEEK: "+ impl.peek());

        System.out.println(Math.abs(2));

    }
}
