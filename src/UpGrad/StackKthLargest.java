package UpGrad;

import java.util.Scanner;
import java.util.Stack;

public class StackKthLargest {
    public static Stack < Integer > sortStack(Stack< Integer > input) {
        //write your code here
        Stack<Integer> sortedStack = new Stack<>();
        while(!input.isEmpty()){
            int temp = input.pop();
            while(!sortedStack.isEmpty() && sortedStack.peek()>temp){
                input.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }

    public static void findKthLargestNum(Stack <Integer> sortedStack, int k) {
        //write your code here
        while(k>1){
            sortedStack.pop();
            k--;
        }
        System.out.println(sortedStack.peek());
    }

    public static void main(String args[]) {
        Stack < Integer > inputStack = new Stack < Integer > ();
        /*Scanner in = new Scanner(System.in);
        int n = in .nextInt();
        for (int i = 0; i < n; i++) {
            inputStack.add( in .nextInt());
        }

        if (inputStack.isEmpty()) {
            System.out.println("stack is empty");
            System.exit(0);
        }

        int k = in .nextInt();
        if (k > inputStack.size()) {
            System.out.println("invalid input");
            System.exit(0);
        }*/

        // This is the temporary stack
        inputStack.push(4);
        inputStack.push(2);
        inputStack.push(0);
        inputStack.push(9);
        inputStack.push(6);
        inputStack.push(1);
        int k=2;


        Stack < Integer > temp = sortStack(inputStack);
        System.out.println(temp);
        findKthLargestNum(temp, k);

    }

}
