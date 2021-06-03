package leetcode.arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int [] num ={1,3,5,6};
        int target = 0;
        System.out.println(searchInsertPosition(num,target));
    }

    private static int searchInsertPosition(int[] num, int target) {
        for(int i = 0 ; i < num.length ; i ++){
            if(num[i] <= target){
                if(num[i] == target){
                    return i;
                }
            }else {
                return i;
            }
        }
        return num.length;
    }
}
