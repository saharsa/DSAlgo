package UpGrad;

import java.util.*;

public class StackLinkedListReverse {
    class Node {
        char data;
        Node next;

        public Node(char new_data) {
            data = new_data;
            next = null;
        }
    }

    Node top;

    // Push and pop operations
    public void push(char new_data) {

        Node new_node = new Node(new_data);
        if (top == null) {

            top = new_node;
        } else {
            new_node.next = top;
            top = new_node;


        }
    }

    public Node pop() {
        Node node = top;
        if (top != null) {
            top = top.next;
        }
        return node;
    }

    // prints contents of stack
    public void display(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    // Reverses the stack using simple
    // linked list reversal logic.
    public Node reverse() {
        // Write your code here.
        Node prev = this.top;
        if (prev != null) {
            Node next = top.next;
            prev.next = null;
            while (next != null) {
                Node temp = next.next;
                next.next = prev;
                prev = next;
                next = temp;
            }
        }else{
            System.out.println("the stack is empty");
        }
        return prev;
    }

    public static void main(String[] args) {
        StackLinkedListReverse obj = new StackLinkedListReverse();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            obj.push(in.next().charAt(0));

        }

        obj.display(obj.top);
        System.out.println(" ");
        // reverse
        Node temp = obj.reverse();
        obj.display(temp);


    }
}
