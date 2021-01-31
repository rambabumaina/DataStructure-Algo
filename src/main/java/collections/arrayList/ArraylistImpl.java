package collections.arrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraylistImpl implements ListInterfaceImpl {

    private int Initial_capacity = 10;
    private int capacity = Initial_capacity;
    private int SIZE = 0;
    private Object[] obj ={};

    ArraylistImpl() {
        obj = new Object[Initial_capacity];
    }

    @Override
    public void add(Object o) {
        if (capacity == SIZE) {
            ensureCapacity();
        }
        obj[SIZE++] = o;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= SIZE) {
            throw new ArrayIndexOutOfBoundsException("please provide right index..."+SIZE);
        }
        return obj[index];
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public void displayAll() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(obj[i] + " ");
        }
        System.out.println();
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= SIZE) {
            throw new ArrayIndexOutOfBoundsException("provide right index to remove elements...");
        }
        Object o = obj[index];
        for (int i = index; i < SIZE - 1; i++) {
            obj[i] = obj[i + 1];
        }
        SIZE--;
        return o;
    }

    @Override
    public boolean removeEle(Object o) {
        Object t = null;
        boolean flag = false;

        for (int i = 0; i < size(); i++) {
            if (obj[i] == o) {
                int index = getIndex(o);
                Object r = remove(index);

                if (r != null){
                    flag=true;
                }
            }
        }
        return flag;
    }

    @Override
    public int getIndex(Object o) {
        int s = -1;
        for (int i = 0 ; i< size() ; i++){
            if(obj[i] == o){
                s = i;
            }
        }
        return s;
    }

    private void ensureCapacity() {
        capacity = (capacity * 3/2)+ 1;
        obj = Arrays.copyOf(obj, capacity);
    }

    public static void main(String[] args) {

        ArraylistImpl impl = new ArraylistImpl();
        impl.add("Ram"); //0
        impl.add("om");
        impl.add("anu");
        impl.add("uuu");  //3

        System.out.println("Capacity: "+ impl.capacity);

        impl.displayAll();
        System.out.println("Size:" + impl.size());

        System.out.println("Get :" + impl.get(2));

        System.out.println("Index : "+ impl.getIndex("anu"));

        System.out.println("Remove: "+impl.removeEle("ddgg"));
        System.out.println("Size:" + impl.size());
        impl.displayAll();
//
//        System.out.println("Size:" + impl.size());
//        impl.displayAll();
    }

}
