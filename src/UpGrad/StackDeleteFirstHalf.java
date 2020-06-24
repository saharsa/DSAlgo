package UpGrad;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StackDeleteFirstHalf {

    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,6};
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++)
            stack.push(arr[i]);
        Queue<Integer> a = new LinkedList<>();
        deleteFirstHalf(stack);
    }

    static void deleteFirstHalf(Stack<Integer> stack){
        reverse(stack);
        int size = (int)(Math.floor(stack.size()/2.0));
        while(size>0){
            stack.pop();
            size--;
        }
        reverse(stack);
        System.out.println(stack);
    }

    static void reverse(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int popped = stack.pop();
            reverse(stack);
            reverseInsert(stack, popped);
        }
    }

    static void reverseInsert(Stack<Integer> stack, Integer element){
        if(stack.isEmpty()){
            stack.push(element);
        }else{
            int temp = stack.pop();
            reverseInsert(stack, element);
            stack.push(temp);
        }
    }

    /*static void deleteFirstHalf(Stack<Integer> stack) {
        // Write your code here
        int size = stack.size() - (int)(Math.floor(stack.size()/2.0));
        Stack<Integer> newStack = new Stack<>();
        int count = stack.size();
        while(count>0){
            if(size>0){
                newStack.push(stack.pop());
            }else{
                stack.pop();
            }
            count--;
            size--;
        }
        count = newStack.size();
        while(count>0){
            stack.push(newStack.pop());
            count--;
        }
        System.out.println(stack);
    }*/
}
