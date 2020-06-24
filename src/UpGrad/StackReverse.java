package UpGrad;

import java.util.ArrayList;
import java.util.Stack;

public class StackReverse {

    public static void main(String[] args) {
        int[] arr = {};
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++)
            stack.push(arr[i]);
        reverseSecondHalf(stack);
    }

    static void reverseSecondHalf(Stack<Integer> stack) {
        // Write your code here
        int reverseLimit = (int)Math.floor(stack.size()/2);
        ArrayList<Integer> poppedElements = new ArrayList<>();
        while(reverseLimit>0){
            poppedElements.add(stack.pop());
            reverseLimit--;
        }
        for(int i=0;i<poppedElements.size();i++){
            stack.push(poppedElements.get(i));
        }
        System.out.println(stack);
    }

    static void reverse(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int temp = stack.pop();
            reverse(stack);
            stack.push(temp);
        }
    }
}
