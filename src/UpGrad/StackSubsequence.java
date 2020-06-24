package UpGrad;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class StackSubsequence {

    public static void main(String[] args) {
        String line1 = "1 2 3";
        String line2 = "3 2 1";
        Stack<Integer> sequence1 = new Stack<Integer>();
        Stack<Integer> sequence2 = new Stack<Integer>();
        int boxIndex = 0;
        for (String elem1 : line1.split(" ")) {
            sequence1.add(Integer.parseInt(elem1));
        }
        for (String elem2 : line2.split(" ")) {
            sequence2.add(Integer.parseInt(elem2));
        }
        Boolean isSubsequence = contains(sequence1, sequence2);
        System.out.println(isSubsequence);
    }

    public static Boolean contains(Stack<Integer> sequence1, Stack<Integer> sequence2) {
        // This block will be filled by the student
        int size = sequence1.size();
        try {
            while (size > 0) {
                int popped1 = sequence1.pop();
                int popped2 = sequence2.pop();

                while (popped1 != popped2) {
                    popped2 = sequence2.pop();
                }

                size--;
            }
        } catch (EmptyStackException e) {
            return false;
        }
        return true;
    }
}
