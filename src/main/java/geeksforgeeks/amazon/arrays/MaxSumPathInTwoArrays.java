package geeksforgeeks.amazon.arrays;

public class MaxSumPathInTwoArrays {

    public static void main(String[] args) {
        MaxSumPathInTwoArrays m = new MaxSumPathInTwoArrays();

        int A[] = {1,2,3,5,8,9,10};
        int B[] = {1,2,3,7,8,9};

        System.out.println( m.maxPathSum(A,B));
    }

    int maxPathSum(int ar1[], int ar2[])
    {
        int i=0, j = 0;
        int sum1 =0 , sum2 = 0;
        int maxPathSum=0;

        while (i< ar1.length && j< ar2.length){

            if(ar1[i] < ar2[j]){
                sum1 += ar1[i];
                i++;
            } else if(ar1[i]> ar2[j]){
                sum2 +=ar2[j];
                j++;
            }else {
                maxPathSum += Math.max(sum1,sum2)+ar1[i];
                sum1=sum2=0;
                i++;
                j++;
            }
        }
        if(i< ar1.length){
            while (i < ar1.length){
                maxPathSum +=ar1[i++];
            }
        }

        if(j <ar2.length){
            while (j < ar2.length){
                maxPathSum += ar2[j++];
            }
        }

        return maxPathSum;
    }

}
