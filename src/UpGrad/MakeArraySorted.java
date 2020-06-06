package UpGrad;

public class MakeArraySorted {
    public static void main(String[] args) {
        //int arr1[] = {1,7,4,5,9,10,18};
        //int arr2[] = {18,13,6,4,1};
        //2 7 8 6 13
        //int arr1[] = {2,7,8,6,13};
        //int arr2[] = {15,11,9,5};
        //int arr1[] = {2,7,8,6,13};
        //int arr2[] = {14,15,16,17};
        //int arr1[] = {2,7,8,9,6,13};
        //int arr2[] = {9,14,16,17};
        int arr1[] = {2,5,4,5,6,13};
        int arr2[] = {1,3,7};
        int rangeStart = 0;
        int rangeEnd = 0;

        for(int i=1;i<arr1.length-1;i++){
            if(arr1[i]<arr1[i-1]){
                if(arr1[i-1]<arr1[i+1]){
                    rangeStart = arr1[i-1];
                    rangeEnd = arr1[i+1];
                    System.out.println(arr1[i]);
                }else {
                    rangeStart = arr1[i-2];
                    rangeEnd = arr1[i];
                    System.out.println(arr1[i-1]);
                }
                break;
            }
        }
        int replacement = -1;
        for(int i=0;i<arr2.length;i++){
            if(arr2[i]>=rangeStart && arr2[i]<=rangeEnd){
                if(arr2[i]>replacement){
                    replacement = arr2[i];
                }
            }
        }

        if(replacement==-1){
            System.out.println(replacement);
        }else{
            System.out.println(replacement);
        }
    }

}
