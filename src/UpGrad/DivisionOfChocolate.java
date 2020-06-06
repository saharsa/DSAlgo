package UpGrad;

public class DivisionOfChocolate {

    public static void main(String[] args) {
        int arr[] = {1,4,3,5,6,4};
        //arr.length, arr, 18, 4
        //int arr[] = {1,2,3,4,5};
        //arr.length, arr, 6, 7
        //int arr[] = {2,5,8,6,1,8,9,2,4,3};
        System.out.println(calculateSubArrays(arr.length, arr, 18, 4));
    }

    static int calculateSubArrays(int n, int arr[], int d, int m){
        int sum = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(i<m){
                sum = sum + arr[i];
            }else {
                sum = sum + arr[i] - arr[i-m];
            }
            if(sum==d && i>=m-1){
                count++;
            }
        }
        return count;
    }
}
