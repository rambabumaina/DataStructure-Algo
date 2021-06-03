package leetcode.Hash;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class HashMapImpl {

    LinkedList<Node>[] bucket;
    int initialCapacity = 5;
    int bucketSize = initialCapacity;

    public HashMapImpl() {
        bucket = new LinkedList[initialCapacity];
    }

    private int getIndex(int hashCode) {
        return hashCode % bucketSize;
    }

    private int getHashCode(int key) {
        int prime = 31;
        return key * prime;
    }

    public void put(Integer key, Integer value) {
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode);
        Node node = new Node(key, value, hashCode);
        if (bucket[index] == null) {
            LinkedList<Node> list = new LinkedList<>();
            list.add(node);
            bucket[index] = list;
        } else {
            LinkedList<Node> list = bucket[index];
            AtomicBoolean flag = new AtomicBoolean(false);
            list.stream().forEach(d -> {
                if (hashCode == d.hashCode && key == d.key) {
                    d.value = value;
                    flag.set(true);
                }
            });

            if (!flag.get()) {
                list.add(node);
            }
        }
    }

    public Integer get(Integer key) {
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode);
        LinkedList<Node> list = bucket[index];

        if (list != null) {
            for (Node s : list) {
                if (hashCode == s.hashCode && s.key == key) {
                    return s.value;
                }
            }
        }
        return null;
    }

    static class Node {
        Integer key;
        Integer value;
        Integer hashCode;

        Node(Integer key, Integer value, Integer hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }
}




