package geeksforgeeks.mustdo.hash;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//https://practice.geeksforgeeks.org/problems/relative-sorting4323/1
public class SortAnArrayAccordingOther {

    public static void main(String[] args) {

//        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
//        int A2[] = {2, 1, 8, 3};

        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {99, 22, 444, 56};

        Arrays.stream(sortA1ByA2(A1, A1.length, A2, A2.length)).forEach(s-> System.out.print(s + " "));
    }

    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0 ; i < N; i ++){
            treeMap.putIfAbsent(A1[i],0);
            treeMap.put(A1[i],treeMap.get(A1[i])+1);
        }

        int k =0;
        for (int i = 0; i < M ; i ++){
            if(treeMap.containsKey(A2[i])){
                int count = treeMap.get(A2[i]);
                Arrays.fill(A1,k, k+count, A2[i]);
                k= k+count;
                treeMap.remove(A2[i]);
            }
        }

        for (Map.Entry<Integer, Integer> entry :treeMap.entrySet()){
            int count = entry.getValue();
            Arrays.fill(A1,k, k+count, entry.getKey());
            k= k+count;
        }
        return A1;
    }
}
