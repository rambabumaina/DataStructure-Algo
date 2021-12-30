package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareList {
    public static void main(String[] args) {

        String ert = "ram,meena";
        List<String> ertL = new ArrayList<>(Arrays.asList(ert.split(",")));
        List<String> adgL = new ArrayList<>(Arrays.asList("ram","maina","meena"));

        System.out.println(ert);
        System.out.println(adgL);

        adgL.retainAll(ertL);

        System.out.println(ert);
        System.out.println(adgL);
    }
}
