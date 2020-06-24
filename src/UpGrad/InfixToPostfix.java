package UpGrad;

import java.util.Stack;

public class InfixToPostfix {

    public static final int PLUS = 0;
    public static final int MINUS = 0;
    public static final int MULTIPLICATION = 1;
    public static final int DIVISION = 1;
    public static final int EXPONENT = 2;

    public static void main(String[] args) {
        //infixToPostfix("a*(b+c)");
        //infixToPostfix("a^b");
        infixToPostfix("j+k*(k^l-m)^(n+o*p)-q+a");
        //jkkl^mnop*+^*qa+
        //jkkl^m-nop*+^*+q-a+
    }

    public static void infixToPostfix(String expression){
        Stack<Character> s = new Stack<>();
        StringBuilder postfixExpr = new StringBuilder();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if((ch>=65 && ch<=90) || (ch>=97 && ch<=122)){
              postfixExpr.append(ch);
            }else if(ch=='('){
                s.push(ch);
            }else if(ch==')'){
                while(s.peek()!='('){
                    postfixExpr.append(s.pop());
                }
                s.pop();
            }else {
                if(s.isEmpty() || getPrecendence(s.peek())<getPrecendence(ch)){
                    s.push(ch);
                }else{
                    while(!s.isEmpty() && getPrecendence(s.peek())>=getPrecendence(ch)){
                        postfixExpr.append(s.pop());
                    }
                    s.push(ch);
                }

            }
        }
        while(!s.isEmpty()){
            postfixExpr.append(s.pop());
        }
        System.out.println(postfixExpr.toString());
    }

    public static int getPrecendence(char operator){
        switch (operator){
            case '+': return PLUS;
            case '-': return MINUS;
            case '*': return MULTIPLICATION;
            case '/': return DIVISION;
            case '^': return EXPONENT;
        }
        return -1;
    }
}
