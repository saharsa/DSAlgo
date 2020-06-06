package UpGrad;

import java.util.HashMap;

public class DuplicateNumbersInArray {
    public static void main(String[] args) {
        int arr[] = {1,4,5,4,1,1,6,8,10};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            Integer val = map.get(arr[i]);
            if(val==null){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],val+1);
                if((val+1)==2) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
