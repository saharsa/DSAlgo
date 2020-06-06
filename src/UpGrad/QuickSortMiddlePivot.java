package UpGrad;

import java.util.Collections;
import java.util.Scanner;

public class QuickSortMiddlePivot {
    public static void main(String[] args) {
        //int arr[] = {15,8,4,16,12,19,3};
        //quickSort(arr, 0, arr.length - 1);
        int arr[] = {2,1,4,3};
        merge(arr, 0, 1, 3);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


    public static int[] merge(int[] numb, int start, int mid, int end) {
        int left = start; //inital index of first subarray
        int right = mid + 1; // initial index of second subarray
        int k = 0; // initial index of merged array
        int[] temp = new int[numb.length];
        while (left <= mid && right <= end) {
            if (numb[left] >= numb[right]) {
                temp[k] = numb[left];
                k++;
                left++;
            } else {
                temp[k] = numb[right];
                k++;
                right++;
            }
        }
        // Copy the remaining elements on left half , if there are any
        while (left <= mid) {
            temp[k] = numb[left];
            k++;
            left++;
        }
        // Copy the remaining elements on right half , if there are any
        while (right <= end) {
            temp[k] = numb[right];
            k++;
            right++;
        }
        // Copy the remaining elements from array t back the numbers array
        left = start;
        k = 0;
        while (left <= end) {
            numb[left] = temp[k];
            left++;
            k++;
        }
        return numb;
    }

    public static void quickSort(int arr[],int left,int right){
        if(left<right){
            int p = partition(arr, left, right);
            quickSort(arr, left, p-1);
            quickSort(arr, p+1, right);
        }
    }

    /*public static int partition(int[] array, int left, int right) {
        int x = array[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array[j].length() <= x.length()) {
                i++;
                String tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }*/

    public static int partition(int arr[], int left, int right){
        int m = left + (right-left)/2;
        int pivotPosition = m;
        int pivot = arr[m];
        int p = left;
        for(int i=left; i<=right; i++){
            if(arr[i]>pivot){
                if(p==pivotPosition){
                    pivotPosition = i;
                }
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                p++;
            }
        }
        int temp = arr[p];
        arr[p] = arr[pivotPosition];
        arr[pivotPosition] = temp;
        return p;
    }

}
