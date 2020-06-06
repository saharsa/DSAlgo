package UpGrad;

import java.util.Scanner;

public class MergeTwoSortedArrays {

    public static void main(String ss[]) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray1 = scanner.nextInt();
        int sizeArray2 = scanner.nextInt();
        int sortedArray1[] = getArrayInput(sizeArray1, scanner);
        int sortedArray2[] = getArrayInput(sizeArray2, scanner);

        int descendingMerge[]=mergeBothInDescendingOrder(sortedArray1, sortedArray2);

        //Write your code here
        for(int i=0;i<descendingMerge.length;i++){
            System.out.println(descendingMerge[i]);
        }

    }

    public static int[] getArrayInput(int size, Scanner scanner){
        int arr[] = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static int[] mergeBothInDescendingOrder(int sortedArray1[], int sortedArray2[]){
        int size1 = sortedArray1.length;
        int size2 = sortedArray2.length;
        int mergedArray[] = new int[size1+size2];
        int i=size1-1,j=size2-1;
        int index = 0;
        while(i>=0 && j>=0){
            if(sortedArray1[i]>sortedArray2[j]){
                mergedArray[index] = sortedArray1[i];
                i--;
            }else{
                mergedArray[index] = sortedArray2[j];
                j--;
            }
            index++;
        }
        while(i>=0){
            mergedArray[index] = sortedArray1[i];
            i--;
            index++;
        }
        while(j>=0){
            mergedArray[index] = sortedArray2[j];
            j--;
            index++;
        }
        return mergedArray;
    }
}
