package UpGrad;

import java.util.Scanner;

public class ArrayIndexEqualsElement {

    public static void main(String[] args) {
        /**
         * Assumptions:
         * a) Known array length
         * b) Array is sorted in ascending order
         * c) Array holds distinct integers
         * d) Array is 1-indexed
         * e) 1<element<Array size, i.e. not inclusive of 0
         *
         * Derived Assumptions:
         * a) Array has positive integers only (since they are User IDs)
         * b) No limit mentioned for array size. Assuming Integer.MAX_VALUE
         */
        //int arr[] = {0,2,3,4,5,6,8};
        //int arr[] = {0,1,2,3,4,5,7,8};
        //int arr[] = {0,1,2,3,4,5,6,8};
        //int arr[] = {1,2,3,4,5,6,7,8};
        //int arr[] = {0,1,2,4,5,6,7};
        //int arr[] = {0,1,3,4,5};
        //int arr[] = {3,4,5,6,7};
        //int arr[] = {-3,-2,0,4,6};

        Scanner scanner = new Scanner(System.in);
        Integer size = scanner.nextInt();

        // Initialize an Integer array with the input size
        Integer arr[] = new Integer[size];

        // Populate the array
        for(Integer i=0;i<size;i++){
            arr[i] = scanner.nextInt();
        }

        try{
            System.out.println(findElementEqualsIndex(arr));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Finds an element in the input array whose value is equal to its index (1-indexed).
     * Uses binary search to find the element. Time complexity O(log n).
     * If element not found throws Exception.
     * @throws Exception NOT_FOUND
     * @param arr Sorted array containing distinct integers that represents IDs of users registered in "UpGrad Book"
     * @return Element that equals its index value (1-indexed)
     */
    public static Integer findElementEqualsIndex(Integer arr[]) throws Exception{
        Integer left = 0;
        Integer right = arr.length-1;
        Integer result = -1;
        while(left<=right) {
            Integer mid = left + (right - left) / 2;
            if (mid + 1 == arr[mid]) {
                result = arr[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(result==-1){
            throw new Exception("NOT_FOUND");
        }
        return result;
    }
}
