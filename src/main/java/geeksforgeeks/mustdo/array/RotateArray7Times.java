package geeksforgeeks.mustdo.array;

public class RotateArray7Times {
    public static void main(String[] args) {

        int input[] = {1, 2, 3, 4, 5, 6};
        int rotateTimes = 5, rotateGroup =5;
        int rotateCounter = 0, index = 0;

        while (true) {
            if (rotateCounter == rotateTimes) {
                break;
            }
            print4Index(input, index, rotateGroup);
            index +=rotateGroup;
            rotateCounter++;
        }
    }

    public static void print4Index( int [] arr, int index, int rotateGroup){
        int count =0 , i =index;
        while (count < rotateGroup){
            int mod = i % arr.length;

            System.out.print(arr[mod]+" ");
            i++;
            count++;
        }
        System.out.println();
    }
}
