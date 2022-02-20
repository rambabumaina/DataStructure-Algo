package recursion;

import java.util.ArrayList;
import java.util.List;

public class SearchTargetElementInAnArray {
    public static void main(String[] args) {
        int target = 3;
        int[] arr = {1, 2, 3, 6, 28, 3, 18};

        System.out.println(findIndex(arr, target, 0));
        System.out.println(searchElement(arr, target, 0));

        List<Integer> list = new ArrayList<>();
        findIndexAll(arr, target, 0, list);
        System.out.println(list);

        //Using single List Object
        System.out.println(findIndexAllWithReturnListUsingSingleReference(arr, target, 0, new ArrayList<>()));

        //Using Multiple List Object
        System.out.println(findIndexAllWithReturnListUsingDifferentListObjects(arr, target, 0));
    }

    //return first index
    private static int findIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }

        return findIndex(arr, target, index + 1);
    }


    //return All indexes
    private static void findIndexAll(int[] arr, int target, int index, List<Integer> list) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        findIndexAll(arr, target, index + 1, list);
    }

    //return All indexes using single object
    private static List<Integer> findIndexAllWithReturnListUsingSingleReference(int[] arr, int target, int index, List<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        return findIndexAllWithReturnListUsingSingleReference(arr, target, index + 1, list);
    }

    //Create new list at every function call and return All indexes while combine the results
    private static List<Integer> findIndexAllWithReturnListUsingDifferentListObjects(int[] arr, int target, int index) {
        List<Integer> list = new ArrayList<>();

        if (index == arr.length) {
            return list;
        }

        //This will contain answers for that function call only
        if (arr[index] == target) {
            list.add(index);
        }

        List<Integer> listObjects = findIndexAllWithReturnListUsingDifferentListObjects(arr, target, index + 1);
        listObjects.addAll(list);
        return listObjects;
    }

    //Search target element
    private static boolean searchElement(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || searchElement(arr, target, index + 1);
    }
}
