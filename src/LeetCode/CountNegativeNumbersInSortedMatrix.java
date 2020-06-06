package LeetCode;

import java.util.Arrays;

public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        int grid1[][] = {{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}};
        int grid2[][] = {{3,2}, {1,0}};
        int grid3[][] = {{1,-1}, {-1,-1}};
        int grid4[][] = {{-1}};
        int grid5[][] = {{8,-2,-2,-2,-4,-5,-5},{-2,-3,-3,-4,-4,-5,-5},{-2,-5,-5,-5,-5,-5,-5},{-3,-5,-5,-5,-5,-5,-5},{-5,-5,-5,-5,-5,-5,-5},{-5,-5,-5,-5,-5,-5,-5},{-5,-5,-5,-5,-5,-5,-5},{-5,-5,-5,-5,-5,-5,-5},{-5,-5,-5,-5,-5,-5,-5}};
        int grid6[][] = {{1,-2,-3}, {-1,-2,-3}};
        Solution1351 solution = new Solution1351();
        System.out.println(solution.countNegatives(grid5));
        //System.out.println(solution.binarySearch(grid1[0]));
        //System.out.println(Arrays.toString(grid1[0]));
    }
}

class Solution1351 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            int arr[] = grid[i];
            int negStartIndex = binarySearch(arr);
            System.out.println(negStartIndex+","+(arr.length-negStartIndex));
            if(negStartIndex>=0){
                count = count + (arr.length-negStartIndex);
            }
        }
        return count;
    }

    public int binarySearch(int arr[]){
        int start = 0;
        int end = arr.length-1;
        int mid = start + (end-start)/2;
        while(start<=end){
            mid = start + (end-start)/2;
            if(arr[mid]<0){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        if(arr[mid]<0){
            return mid;
        }else if(start>=end){
            return mid+1;
        }
        return -1;
    }
}


