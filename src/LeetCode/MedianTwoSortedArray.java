package LeetCode;

import java.util.Arrays;

class MedianTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int o = m+n;
        int[] nums3 = new int[o/2+1];
        int i=0,j=0,k=0;
        int count = o/2;
        while(i<m && j<n){

            if(nums1[i]<nums2[j]){
                nums3[k] = nums1[i];
                i++;
            }else{
                nums3[k] = nums2[j];
                j++;
            }
            k++;
            if(k==o/2){
                break;
            }
        }
        while(i<m){

            nums3[k] = nums1[i];
            i++;
            k++;
            if(k>=o/2){
                break;
            }
        }
        while(j<n){

            nums3[k] = nums2[j];
            j++;
            k++;
            if(k>=o/2){
                break;
            }
        }
        double median = 0.0;
        System.out.println(Arrays.toString(nums3));
        if((o&1)==0){
            median = (double)(nums3[(int)(o/2)] + nums3[(int)(o/2)-1])/2.0;
        }else{
            System.out.println(o);

            median = nums3[o/2];

        }
        return median;
    }

    public static void main(String[] args) {
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
