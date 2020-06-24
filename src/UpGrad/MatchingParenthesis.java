package UpGrad;

import java.util.Stack;

public class MatchingParenthesis {
    public static void main(String[] args) {
        System.out.println(match("(){()[]}"));
        System.out.println(match("{(})"));
    }

    public static boolean match(String word){
        char[] characters = word.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<characters.length;i++){
            if(characters[i]=='(' || characters[i]=='{' || characters[i]=='['){
                stack.push(characters[i]);
            }else{
                if(characters[i]==')' || characters[i]=='}' || characters[i]==']'){
                    char popped = stack.pop();
                    if(!((popped=='(' && characters[i]==')') || (popped=='{' && characters[i]=='}') || (popped=='[' && characters[i]==']'))){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
