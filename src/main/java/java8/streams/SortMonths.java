package java8.streams;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SortMonths {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("Feb");
        list.add("Jan");

        list.add("Apr");
        list.add("Mar");

        list.add("June");
        list.add("May");

        list.add("Aug");
        list.add("July");

        list.add("Oct");
        list.add("Sep");

        list.add("Dec");
        list.add("Nov");


        list.stream().sorted((a, b) -> {
            try {
                SimpleDateFormat smp = new SimpleDateFormat("MMM");
                return smp.parse(a).compareTo(smp.parse(b));
            } catch (ParseException e) {
                System.out.println("Fail to parse...");
                return 1;
            }
        }).forEach(System.out::println);
    }
}
