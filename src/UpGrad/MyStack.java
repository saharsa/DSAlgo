package UpGrad;

import java.util.Scanner;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        /*Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        printFifthElementFromEnd(stack);*/
        Stack<Character> s = new Stack<Character>();
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        char[] characters = data.toCharArray();
        for(int i=0;i<characters.length;i++){
            s.push(characters[i]);
        }
        printReverse(s);
    }

    static void printFifthElementFromEnd(Stack<Integer> stack) {
        // Write your code here
        if(stack.size()<=4){
            System.out.println("There are not enough elements in the stack");
            return;
        }
        int pops = 1;
        while (pops<5){
            stack.pop();
            pops++;
        }
        System.out.println(stack.peek());
    }

    static void printFifthElementFromStart(Stack<Integer> stack) {
        // Write your code here
        if(stack.size()<=4){
            System.out.println("There are not enough elements in the stack");
            return;
        }
        int pops = stack.size()-5;
        while (pops>0){
            stack.pop();
            pops--;
        }
        System.out.println(stack.peek());
    }

    static void printReverse(Stack<Character> word){
        int size = word.size();
        while(size>0){
            System.out.print(word.pop());
            size--;
        }
    }
}
