package amazon.arrays;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomSongPlay {
    public static void main(String[] args) {

        Set<Integer> songs = new HashSet<>(20);
        Random r = new Random();

        while (songs.size() <20) {
            Integer rand = r.nextInt(20);
            System.out.println(">>" + rand);
            if (checkIfSongPlayed(songs, rand)) {
                rand = r.nextInt(20);
            } else {
                songs.add(rand);
            }
        }

        songs.stream().forEach(System.out::println);
    }

    private static boolean checkIfSongPlayed(Set<Integer> songs, int rand) {
        return songs.contains(rand);
    }


}
