package UpGrad;

import java.util.*;

public class MaxProductQuadruple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }

        int max =  maxProdQuad(n,arr);
        if(max == -1)
            System.out.println("No Maximum Product Quadruple");
        else
            System.out.println(max);

    }
    static int maxProdQuad(int n, int[] arr){
        // Write your code here
        int max = -1;
        if(n>=4){
            mergeSort(arr, 0, n-1);
            int firstMax = arr[n-1];
            int secondMax = arr[n-2];
            int thirdMax = arr[n-3];
            int fourthMax = arr[n-4];
            int firstMin = arr[0];
            int secondMin = arr[1];
            int thirdMin = arr[2];
            int fourthMin = arr[3];
            int x = firstMax*secondMax*thirdMax*fourthMax;
            int y = firstMin*secondMin*thirdMin*fourthMin;
            int z = firstMin*secondMin*firstMax*secondMax;
            if(x>y && x>z){
                max = x;
            }else if(y>z && y>x){
                max = y;
            }else{
                max = z;
            }
        }
        return max;
    }

    static void mergeSort(int arr[], int left, int right){
        if(left<right){
            int mid = left + (right-left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int arr[], int left, int mid, int right){
        int lSize = mid-left+1;
        int rSize = right-mid;
        int lArr[] = new int[lSize];
        int rArr[] = new int[rSize];
        for(int i=0;i<lSize;i++){
            lArr[i] = arr[left+i];
        }
        for(int j=0;j<rSize;j++){
            rArr[j] = arr[mid+j+1];
        }
        int l = 0;
        int r = 0;
        int p = left;
        while(l<lSize && r<rSize){
            if(lArr[l]<rArr[r]){
                arr[p] = lArr[l];
                l++;
            }else{
                arr[p] = rArr[r];
                r++;
            }
            p++;
        }
        while(l<lSize){
            arr[p] = lArr[l];
            l++;
            p++;
        }
        while(r<rSize){
            arr[p] = rArr[r];
            r++;
            p++;
        }
    }
}

