package UpGrad;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePalindrome {
    public static void main(String[] args) {
        checkPalindrome("amba");
    }

    public static void checkPalindrome(String input){
        Queue<Character> queue = new LinkedList<>();
        int i=input.length()-1;
        while(i>=0){
            queue.add(input.charAt(i));
            i--;
        }
        StringBuilder reversed = new StringBuilder();
        while(!queue.isEmpty()){
            reversed = reversed.append(queue.remove());
        }
        if(reversed.toString().equals(input)){
            System.out.println("The given input is a palindrome.");
        }else{
            System.out.println("The given input is not a palindrome.");
        }
    }
}
