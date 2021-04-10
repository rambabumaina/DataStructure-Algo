package geeksforgeeks.amazon.bst;

//https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
public class FindEleSortedAndRotatedArray {
    public static void main(String[] args) {
        FindEleSortedAndRotatedArray f = new FindEleSortedAndRotatedArray();
        int [] arr = {5,6,7,8,9,10,1,2,3,4};
        int len = arr.length-1;
        int ele = 4;
        System.out.println(f.search(arr,0, len,ele));
    }

    int search(int arr[], int l, int h, int key)
    {
        if(l<=h){
            int mid = l+(h-l)/2;

            if(arr[mid] == key){
                return mid;
            }

            //If arr[mid] is greater then arr[l] then arr is sorted
            if(arr[l] < arr[mid]){
                //If number is with in the arr[mid] and low
                if(key <= arr[mid] && key >= arr[l]){
                   return search(arr,l, mid-1,key);
                }else{
                    return search(arr,mid+1, h,key);
                }
            }else {
                if(key >= arr[mid] && key <= arr[h]){
                    return search(arr,mid+1, h,key);
                }else{
                    return search(arr,l, mid-1,key);
                }
            }
        }
        return -1;
    }
}
