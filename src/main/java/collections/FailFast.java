package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FailFast {
    public static void main(String[] args) {

        Map<String, String> str = new HashMap<>();
        str.put("rtr","ddg");
        str.put("rr","dd");

        for (Map.Entry<String,String> entry:str.entrySet()){
            str.put("rr","fff");
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }

        str.forEach((k, v)->{

            System.out.println(k);
        });

        List<String> arrayList = new ArrayList<String>();
        arrayList.add("ankit");
        arrayList.add("javaMadeSoEasy");

        System.out.println("-------use iterator-------");
        // fail-fast
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
           // arrayList.add("newEle"); // unComment to avoid ConcurrentModificationException
            System.out.println(iterator.next());
        }
    }
}
