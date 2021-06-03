package leetcode.Hash;

public class HashMapTest {
    public static void main(String[] args) {
        HashMapImpl map = new HashMapImpl();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        map.put(5, 50);
        map.put(6, 60);
        map.put(7, 70);
        map.put(8, 80);
        map.put(9, 90);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
        System.out.println(map.get(5));
        System.out.println(map.get(6));
        System.out.println(map.get(7));
        System.out.println(map.get(8));
        System.out.println(map.get(9));
    }
}
