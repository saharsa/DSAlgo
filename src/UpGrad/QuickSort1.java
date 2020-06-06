package UpGrad;

import java.util.Scanner;

public class QuickSort1 {

    public static int partition(String array[], int left, int right) {

        int p = left;
        String pivot = array[right];
        for (int i = left; i < right; i++) {
            if (array[i].length() <= pivot.length()) {
                String temp = array[i];
                array[i] = array[p];
                array[p] = temp;
                p++;
            }
        }

        String temp = array[right];
        array[right] = array[p];
        array[p] = temp;

        return p;
    }

    public static void quickSort(String array[], int left, int right) {
        if (left < right) {
            int position = partition(array, left, right);
            quickSort(array, left, position - 1);
            quickSort(array, position + 1, right);
        }

    }

    //Write your code here
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String arr[] = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.next();
        }
        quickSort(arr, 0, size - 1);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
}
