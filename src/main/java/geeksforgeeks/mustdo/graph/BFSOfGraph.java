package geeksforgeeks.mustdo.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BFSOfGraph {

    public static void main(String[] args) {
        int rotate = rotate("abcdef", "abdcfe");
        System.out.println(rotate);

    }

    public static int rotate(String S , String U){
        StringBuffer buffer = new StringBuffer();
        int i =0;
        int rotationCount =0;
        while (i < S.length()){
            if(S.charAt(i) != U.charAt(i)){
               rotationCount = findRotationcount(i,U.charAt(i),S, U);
               break;
            }
            i++;
        }
        buffer.append(S.substring(0, 2));
        System.out.println(buffer.toString());

        int rotation = 0;
        for (int j = i ; j < S.length(); j+=rotationCount){
            StringBuffer sb = new StringBuffer();
            String subs = S.substring(j,j+rotationCount);
            sb.append(subs);
            sb.reverse();
            buffer.append(sb);
            rotation++;
        }

        return rotation;
    }

    private static int  findRotationcount(int i, char c, String s, String u) {
        int counter = 1;
        for (int j = i; j < s.length(); j++){
            if(s.charAt(i) == u.charAt(j)){
                break;
            }
            counter++;
        }
        return counter;
    }
}
