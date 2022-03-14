package geeksforgeeks.mustdo.recurssion;

//https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
public class FloodFillAlgorithm {
    public static void main(String[] args) {
        int[][] input = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;

        floodFill(input, sr, sc, newColor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];

        floodUtil(image, sr, sc, newColor, color);

        printMayArray(image);
        return image;
    }

    private static void printMayArray(int[][] image) {
        for (int i = 0 ; i < image.length; i++){
            for (int j =0 ; j < image.length ;j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void floodUtil(int[][] image, int sr, int sc, int newColor, int color) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image.length) {

            if (image[sr][sc] == color) {
                image[sr][sc] = newColor;

                floodUtil(image, sr - 1, sc, newColor, color);
                floodUtil(image, sr + 1, sc, newColor, color);
                floodUtil(image, sr, sc - 1, newColor, color);
                floodUtil(image, sr, sc + 1, newColor, color);
            }
        }
    }
}
