package UpGrad;

import java.util.*;

public class PartitionArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        partitionNegativeAndPositive(n, arr);
    }

    // Method to partition negative and positive numbers without comparing with 0
    static void partitionNegativeAndPositive(int n, int arr[]) {
        // Write your code here
        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();
        p1.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if((arr[i]^arr[0]) >= 0){
                p1.add(arr[i]);
            }else{
                p2.add(arr[i]);
            }
        }
        if(arr[0]<0){
            if(p1.size()>0){
                printArray(p1);
            }else{
                System.out.println("Array doesn't have negative numbers");
            }
            if(p2.size()>0){
                printArray(p2);
            }else{
                System.out.println("Array doesn't have positive numbers");
            }
        }else{
            if(p1.size()>0){
                printArray(p1);
            }else{
                System.out.println("Array doesn't have positive numbers");
            }
            if(p2.size()>0){
                printArray(p2);
            }else{
                System.out.println("Array doesn't have negative numbers");
            }
        }
    }

    static void printArray(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
}

