package amazon.bst;

public class BST {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int len = arr.length-1;
        int ele = 11;


        System.out.println("Recursion: "+findElementUsingRecursion(arr,0,len,ele));
        System.out.println("Iterative : " + findElementUsingIterative(arr,0,len,ele));
    }


    //Recursion
    static int findElementUsingRecursion(int [] arr, int l, int r, int n) {

        //Termination condition
        if(r>=l){

            int mid = l+ (r-l)/2;

            if(arr[mid] ==n){
                return mid;
            }

            if(arr[mid] > n) {
                return findElementUsingRecursion(arr, l, mid - 1, n);
            }else {
                return findElementUsingRecursion(arr, mid+1, r, n );
            }
        }

        //we will reach here when element not there in the list;
        return -1;
    }


    static int findElementUsingIterative(int [] arr,int l, int r, int n){

        while (l<=r){
            int mid = l+ (r-l)/2;

            if(arr[mid] == n){
                return mid;
            }

            if (arr[mid] > n){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return -1;
    }
}
