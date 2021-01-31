package sapient;

import java.util.HashMap;
import java.util.Map;

public class ComputingSystem {

    public static void main(String[] args) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char str [] = "MCMXLIV".toCharArray();//1000+(1000-100)
    }
}
