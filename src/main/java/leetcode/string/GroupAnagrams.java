package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {
    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs).forEach(System.out::print);
    }

    //using sorting logic
    //time = n*Klogk + space = n solution
    static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs){

            //sort all strings before adding into map
            String sortedString = Stream.of(s.split("")).sorted().collect(Collectors.joining());

            //make sortedString key and List is a value
            //if there is not key then add new list
            if (!map.containsKey(sortedString)){
               map.put(sortedString, new ArrayList<>());
            }

            //By now all the keys will have list, now get the list add the value
            map.get(sortedString).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
