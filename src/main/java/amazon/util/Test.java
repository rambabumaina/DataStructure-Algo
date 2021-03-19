package amazon.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test{

    public static void main(String[] args) {
        HashMap <String, Integer> hm = new HashMap<>();
        hm.put(null,1);

        Set s = hm.keySet();
        Iterator i = s.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}