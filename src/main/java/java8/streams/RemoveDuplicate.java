package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("Ram", "vaibhav","DJ"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Ram", "vaibhav"));

        List<String> result = list1.stream().filter(f-> !list2.contains(f)).collect(Collectors.toList());
        result.stream().forEach(f -> System.out.println(f));
    }
}
