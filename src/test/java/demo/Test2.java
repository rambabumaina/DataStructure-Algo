package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {

        List<Integer> ids = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

//        for (int id :ids) {
//            if(id == 3){
//                ids.remove(id); // Problem concurrent modification exception
//            }
//            System.out.println(id);
//        }
//

        //Solution: 1
        //Java8 : concurrent modification solution in
        System.out.println("Before .." + ids);
        ids.removeIf(id -> id == 3);
        System.out.println("After..." + ids);

        //Solution 2 : Use iterator remove method
        Iterator<Integer> iterator = ids.iterator();
        while (iterator.hasNext()) {
            int id = iterator.next();

            if (id == 3) {
                iterator.remove();
            }
            System.out.println(id);
        }

        // Solution 3 : use another list to remove
        List<Integer> removeIds = new ArrayList<>();
        for (int id : ids) {
            if (id == 5) {
                removeIds.add(id);
            }
            System.out.println(id);
        }

        System.out.println("Before..." + ids);
        ids.removeAll(removeIds);
        System.out.println("After..." + ids);
    }
}
