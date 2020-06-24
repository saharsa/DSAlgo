package UpGrad;

import java.util.Scanner;
import java.util.Stack;

public class StackSort {

    public static void main(String args[]) {
        int[] arr = {6,12,3,4};
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++)
            stack.push(arr[i]);
        sort(stack);
        System.out.println(stack);
    }

    public static void sort(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int popped = stack.pop();
            sort(stack);
            sortedInsert(stack, popped);
        }
    }

    public static void sortedInsert(Stack<Integer> stack, Integer element){
        if(stack.isEmpty() || element>stack.peek()){
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        sortedInsert(stack, element);
        stack.push(temp);
    }
}
