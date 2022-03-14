package backtracking;

import java.util.Arrays;

/**
 * Back tracking:
 * While you are going back change the changes that is made by previous recursion calls
 * <p>
 * While going back on the recursion tree make the maje in original form
 */

public class MazeAllDirection {
    public static void main(String[] args) {
        //3*3: matrix you have to go from (0,0) to (3,3), you can traverse in all direction, what are the possible ways
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        // mazeAllPath(maze, 0, 0, "");


        ///

        int[][] paths = new int[maze.length][maze[0].length];
        mazeAllPathPrintStep(maze, 0, 0, "", paths, 1);
    }

    private static void mazeAllPath(boolean[][] maze, int row, int col, String path) {

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        //If path has false that means return from its visited
        if (!maze[row][col]) return;

        // If not false that means, I am considering in my path, make it false
        // *****  Make a change
        maze[row][col] = false;

        if (row < maze.length - 1)
            mazeAllPath(maze, row + 1, col, path + "D");

        if (col < maze[0].length - 1)
            mazeAllPath(maze, row, col + 1, path + "R");

        if (row > 0)
            mazeAllPath(maze, row - 1, col, path + "U");

        if (col > 0)
            mazeAllPath(maze, row, col - 1, path + "L");

        //This line is where this function will be over,
        // So before function gets removed from stack remove the changes that you have made
        // *****  Revert a change, this is called backtracking
        maze[row][col] = true;
    }


    private static void mazeAllPathPrintStep(boolean[][] maze, int row, int col, String path, int[][] paths, int step) {

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            paths[row][col] = step;

            for (int[] p : paths) {
                System.out.println(Arrays.toString(p));
            }
            System.out.println(path);
            System.out.println();
            return;
        }

        //If path has false that means return from its visited
        if (!maze[row][col]) return;

        // If not false that means, I am considering in my path, make it false
        // *****  Make a change
        maze[row][col] = false;
        paths[row][col] = step;

        if (row < maze.length - 1)
            mazeAllPathPrintStep(maze, row + 1, col, path + "D", paths, step + 1);

        if (col < maze[0].length - 1)
            mazeAllPathPrintStep(maze, row, col + 1, path + "R", paths, step + 1);

        if (row > 0)
            mazeAllPathPrintStep(maze, row - 1, col, path + "U", paths, step + 1);

        if (col > 0)
            mazeAllPathPrintStep(maze, row, col - 1, path + "L", paths, step + 1);

        //This line is where this function will be over,
        // So before function gets removed from stack remove the changes that you have made
        // *****  Revert a change, this is called backtracking
        maze[row][col] = true;
        paths[row][col] = 0;
    }

}
