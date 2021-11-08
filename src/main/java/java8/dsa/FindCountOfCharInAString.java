package java8.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindCountOfCharInAString {

    public static void main(String[] args) {
        String str = "rambabu";
        Character [] charArr =str.chars().mapToObj(ch -> (char)ch).toArray(Character[] :: new);

        Map<Character, Integer> mp = Arrays.stream(charArr).collect(Collectors.toMap(
                k -> (char) k,
                v -> 1,
                Integer::sum));

        System.out.println(mp);


    }
}
