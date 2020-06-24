package UpGrad;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueue {

    /*implementing queue using linked list */
    Queue< Integer > q = new LinkedList<>();

    /* Push operation of stack using queue*/
    void push(int x) {
        //write your code here
        int size = q.size();
        q.add(x);
        while(size>0){
            q.add(q.remove());
            size--;
        }
    }

    /*Removes the top element of the stack*/

    int pop() {
        //write your code here
        if(q.isEmpty()){
            throw new EmptyStackException();
        }
        return q.remove();
    }


    /*Returns the element at the top of the stack */
    int top() {
        //write your code here
        if(q.isEmpty()){
            throw new EmptyStackException();
        }
        return q.peek();
    }


    public static void main(String[] args) {
        StackUsingQueue obj = new StackUsingQueue();
        Scanner in = new Scanner(System.in);

        /*Enter the number of elements you want to add in the stack */

        int n = in .nextInt();

        /*Enter the elements of the stack */
        for (int i = 0; i < n; i++) {
            obj.push( in .nextInt());
        }

        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
    }
}
