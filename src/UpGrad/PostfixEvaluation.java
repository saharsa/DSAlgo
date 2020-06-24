package UpGrad;

import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        postfixEvaluation("123*-4- ");
        postfixEvaluation("12+");
    }

    public static void postfixEvaluation(String exp){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch>=48 && ch<=57){
                stack.push(Integer.parseInt(""+ch));
            }else if(!stack.isEmpty() && stack.size()>1){
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(eval(n1,n2,ch));
            }
        }
        System.out.println(stack.peek());
    }

    public static int eval(int n1, int n2, char operator){
        switch (operator){
            case '+': return n1+n2;
            case '-': return n1-n2;
            case '*': return n1*n2;
            case '/': return n1/n2;
            case '^': return n1^n2;
        }
        return -1;
    }
}
