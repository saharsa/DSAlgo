package UpGrad;

import java.util.Deque;
import java.util.LinkedList;

public class DequePalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcda"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abba"));
    }
    public static boolean isPalindrome(String word){
        Deque<Character> deq = new LinkedList<>();
        for(int i=0;i<word.length();i++){
            deq.add(word.charAt(i));
        }
        while(deq.size()>1){
            char first = deq.removeFirst();
            char last = deq.removeLast();
            if(first!=last){
                return false;
            }
        }
        return true;
    }
}
