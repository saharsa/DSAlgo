package UpGrad;

import java.util.BitSet;

public class MissingNumbers {
    public static void main(String[] args) {
        //int arr[] = {3,10,8,4};
        //efficient(arr,10);
        //notEfficient(arr);
        //int ARRAY[] = {1,2,3,5,6};
        //xorSingle(ARRAY, ARRAY.length);
        int ARRAY[] = {1,3,4,6};
        xorMultiple(ARRAY, ARRAY.length);
    }

    static void efficient(int arr[], int n){
        BitSet a = new BitSet(n+1);
        for(int i=0;i<arr.length;i++){
            a.set(arr[i], true);
        }

        for(int i=1;i<n;i++){
            if(a.get(i)==false){
                System.out.print(i+" ");
            }
        }
    }

    static void xorMultiple(int ARRAY[], int n){
        int XOR = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            XOR ^= ARRAY[i];
            XOR ^= (count + 1);
            if(ARRAY[i]!=(count+1)){
                XOR ^= ARRAY[i];
                System.out.print(XOR+" ");
                XOR ^= XOR;
                count++;
            }
            count++;
        }
    }

    static void xorSingle(int ARRAY[], int n){
        int XOR = 0;
        for(int i=0; i<n; i++) {
            XOR ^= ARRAY[i];
            XOR ^= (i + 1);
        }
        /*int XOR1 = 0;
        for(int i=1; i<=n+1; i++) {
            XOR1=XOR1^i;
        }
        int XOR2 = 0;
        for(int i=0; i<n; i++) {
            XOR2=XOR2^ARRAY[i];
        }*/

        /*System.out.println(XOR);
        System.out.println(XOR1);
        System.out.println(XOR2);
        System.out.println(XOR1^XOR2);
         */
        System.out.println(XOR^ARRAY.length+1);

    }

    static void notEfficient(int arr[]){
        mergeSort(arr, 0, arr.length-1);
        for(int i=1;i<arr.length;i++){
            if((arr[i-1])!=(arr[i]-1)){
                for(int j=arr[i-1]+1;j<=arr[i]-1;j++){
                    System.out.print(j+" ");
                }
            }
        }
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
