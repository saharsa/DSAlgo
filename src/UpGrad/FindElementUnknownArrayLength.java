package UpGrad;

import java.util.Scanner;

public class FindElementUnknownArrayLength {
    public static void main(String[] args) {
        /**
        Scanner scanner = new Scanner(System.in);
        Integer size = scanner.nextInt();
        Integer key = scanner.nextInt();
        Integer arr[] = new Integer[size];

        for(int i=0;i<size;i++){
            arr[i] = scanner.nextInt();
        }
        */

        Integer arr[] = {1,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        int key = 21;

        try{
            System.out.println(findPositionOfElement(arr, key));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static int findPositionOfElement(Integer arr[], int key)throws Exception{
        Integer index = 0, exp = 0, position = -1;
        while(true){
            try {
                if(arr[index]==key){
                    position = index+1;
                    break;
                }else if(arr[index]<key){
                    index = (int) Math.pow(2, exp);
                    exp++;
                }else{
                    break;
                }
            }catch(Exception e){
                break;
            }
        }
        int left = (index)/2 + 1;
        int right = index-1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            try{
                if(arr[mid]==key){
                    position=mid+1;
                    break;
                }else if(arr[mid]<key){
                    left = mid +1;
                }else{
                    right = mid-1;
                }
            }catch (Exception e){
                right = mid-1;
            }
        }
        if(position==-1){
            throw new Exception("NOT_FOUND");
        }
        return position;
    }
}
