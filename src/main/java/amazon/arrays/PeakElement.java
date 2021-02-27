package amazon.arrays;

public class PeakElement {

    public static void main(String[] args) {
        PeakElement e = new PeakElement();

        int arr[] = {8,8,8,5,5,5,6,6,6};

        System.out.println(e.peakElement(arr, arr.length));
    }

    public int peakElement(int[] arr,int n)
    {

        if(arr.length == 1 || arr[0] > arr[1] ){
            return 0;
        }else {

            if(arr[arr.length-2] < arr[arr.length-1]){
                return arr.length-1;
            }

            for (int i = 1; i< arr.length-1;i++){
                if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                    return i;
                }
            }

        }
        return 0;
    }
}
