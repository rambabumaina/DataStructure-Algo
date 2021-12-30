package leetcode.Hash;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class ClickCountURLS {
    public static void main(String[] args) {
        String [] urls = {"Google.com","Amazon.com","youtube.com","Google.com","Amazon.com","Google.com","youtube.com","youtube.com","youtube.com"};

        Map<String, Integer> counts = new HashMap<>();

        for (String s : urls){
            counts.putIfAbsent(s,0);
            counts.put(s,counts.get(s)+1);
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(counts.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        System.out.println(list);
        System.out.println(counts);
    }
}
