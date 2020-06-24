package UpGrad;

import java.util.Stack;

public class StackDuplicateParenthesis {
    public static void main(String[] args) {
        System.out.println(findDuplicateParenthesis("(a+b)"));
        System.out.println(findDuplicateParenthesis("((a+b))"));
        System.out.println(findDuplicateParenthesis("((a+b)+c)"));
        System.out.println(findDuplicateParenthesis("((a+b)+)"));
    }

    public static String findDuplicateParenthesis(String inputString) {
        //write your code
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<inputString.length();i++){
            char ch = inputString.charAt(i);
            if(ch!=')'){
                stack.push(ch);
            }else{
                int count = 0;
                while(stack.peek()!='('){
                    count++;
                    stack.pop();
                }
                if(count<=1){
                    return "Input string contains duplicate parenthesis";
                }
            }
        }
        return "Input string does not contain duplicate parenthesis";
    }
}
