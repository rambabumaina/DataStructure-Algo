package backtracking;


import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * This is famous problem, in a given matrix 3*3 , how many way3 to reach (0,0) -> (3,3)
 * Condition: you can only go down and right
 * ----->
 * Start
 * |  |  |  |
 * |  |  |  |
 * |  |  |  |
 * end
 */
public class MazeProblem {
    public static void main(String[] args) {

//        System.out.println("Path to reach :" + mazeCountPath(3, 3));
//
//        mazePathPrint(3,3,"");
//
//        System.out.println(mazePathReturn(3,3,""));
//
//        mazePathPrintDiagonal(3,3,"");

        //When given board with restrictions
        //False means obstacles , you can not cross
        boolean [][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };

        mazePathWithObstacles(0,0,maze,"");
    }

    // when count path
    private static int mazeCountPath(int row, int col) {

        if (row == 1 || col == 1) {
            return 1;
        }

        int left = mazeCountPath(row - 1, col);
        int right = mazeCountPath(row, col - 1);
        return left + right;
    }

    //when print path
    private static void mazePathPrint(int row, int col, String path) {

        if (row == 1 && col == 1) {
            System.out.println(path);
            return;
        }

        if (row >1)
        mazePathPrint(row - 1, col, path + "V");

        if(col >1)
        mazePathPrint(row, col - 1, path + "H");
    }


    //When return list of paths
    private static List<String> mazePathReturn(int row, int col, String path) {

        if (row == 1 && col == 1) {
            List<String> result = new ArrayList<>();
            result.add(path);
            return result;
        }

        List<String> result = new ArrayList<>();

        if (row >1)
            result.addAll( mazePathReturn(row - 1, col, path + "D"));

        if(col >1)
            result.addAll(mazePathReturn(row, col - 1, path + "R"));
        return result;
    }

    //When 3 ways to go : list of paths
    private static void mazePathPrintDiagonal(int row, int col, String path) {

        if (row == 1 && col == 1) {
            System.out.println(path);
            return;
        }

        if (row >1)
            mazePathPrintDiagonal(row - 1, col, path + "V");

        if(col >1)
            mazePathPrintDiagonal(row, col - 1, path + "H");

        if (row >1 && col >1)
            mazePathPrintDiagonal(row - 1, col-1, path + "D");
    }

    private static void mazePathWithObstacles(int row, int col, boolean[][] maze , String path) {

        if (col == maze.length-1 && row == maze[0].length -1) {
            System.out.println(path);
            return;
        }

        //When find river in the path
       if(!maze[row][col]) return;

        if (row < maze.length-1)
            mazePathWithObstacles(row + 1, col, maze,path + "D");

        if(col < maze[0].length-1)
            mazePathWithObstacles(row, col + 1, maze,path + "R");
    }
}
