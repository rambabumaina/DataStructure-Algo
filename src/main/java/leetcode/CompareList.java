package leetcode;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class CompareList {
    public static void main(String[] args) {
        Date in = new Date();
        Instant instant = Instant.ofEpochMilli(in.getTime());
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        Date date = Date.from(instant);
        System.out.println(date);
    }
}
