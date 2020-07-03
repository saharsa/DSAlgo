package UpGrad.AlgorithmAssignment;

import java.util.Scanner;

/**
 * Assumptions: a) Unknown array length b) Array is sorted in ascending order c) Array holds
 * distinct integers d) Array is 1-indexed
 *
 * Derived Assumptions: a) Array has positive integers only (since they are User IDs) b) No limit
 * mentioned for array size. Assuming Integer.MAX_VALUE for simplicity.
 *
 * Sample Test Case int[] arr = {1,2,3,4,5,6,7,8,10,12,14,15,16,17,18,19}; int key = -1 to 20;
 */
public class BinarySearchAssignmentB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Size of the array
        int size = scanner.nextInt();

        // Element to be searched in the array
        int key = scanner.nextInt();

        int[] arr = new int[size];
        // Populating the array
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        try {
            System.out.println(findPositionOfElement(arr, key));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Searches for an element in the input array of unknown length (1-indexed) and returns its index.
     * First uses a while loop to find the upper limit of the array. Time complexity O(log n). Once
     * upper limit is found, uses binary search to find the element. Time complexity O(log n). If
     * element not found throws Exception.
     *
     * @param arr Sorted array containing distinct integers that represents IDs of users registered in
     *            "UpGrad Book" of unknown length
     * @param key Value to be searched in arr
     * @return Index of the key in arr if present, else throws Exception
     * @throws Exception NOT_FOUND
     */
    public static int findPositionOfElement(int[] arr, int key) throws Exception {

        int index = 0, position = -1;

        /*
        Find an end range in the array up to which binary search needs to be performed.
        Begin with index 0;
        If arr[index] is equal to key, set position and break.
        As long as arr[index]<key, increment index by powers of 2 i.e. 2^0, 2^1 and so on, else it means we have found an upper limit (or end range) and can exit the loop.
        If the index value is causing ArrayOutOfBoundsException, then exit loop as well.
         */
        while (true) {
            try {
                if (arr[index] == key) {
                    position = index + 1;
                    break;
                } else if (arr[index] < key) {
                    index = (index == 0 ? 1 : index * 2);
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }
        // If key was not found by the above while loop, then proceed to perform binary search on the upper limit determined by it.
        if (position == -1) {
            /*
            The previous while loop exits when arr[index]>key, for lets assume index=2^(k).
            In the iteration prior to the exit, the index value was 2^(k-1)<key.
            Thus we can safely assume that 2^(k-1)<key<2^(k).
            Thus left value is 2^(k)/2 = 2^(k-1) +1.
            Right value is 2^(k) -1.
            And then perform binary search on the left to right range.
             */
            int left = (index) / 2 + 1;
            int right = index - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                try {
                    if (arr[mid] == key) {
                        position = mid + 1;
                        break;
                    } else if (arr[mid] < key) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } catch (Exception e) {
                    right = mid - 1;
                }
            }
            if (position == -1) {
                throw new Exception("NOT_FOUND");
            }
        }
        return position;
    }
}

