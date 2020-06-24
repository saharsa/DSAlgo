package UpGrad;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {
        ImplementQueue obj = new ImplementQueue();
        obj.enQueue(1);
        obj.enQueue(4);
        obj.enQueue(3);
        obj.print();
        obj.deQueue();
        obj.print();
        obj.enQueue(2);
        obj.print();
        obj.deQueue();
        obj.deQueue();
        obj.print();
    }
}

class ImplementQueue {

    Stack<Integer> stack = new Stack<Integer>();

    //The basic push and pop method of a stack are used to create enqueue and dequeue function of a queue
    public void enQueue(int newData) {
        //Write your code here
        if(!stack.isEmpty()){
            int temp = stack.pop();
            enQueue(newData);
            stack.push(temp);
        }else{
            stack.push(newData);
        }
    }

    // Function to deQueue an item from queue
    public void deQueue() {
        //Write your code here
        if(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public void print(){
        System.out.println(stack);
    }

}
