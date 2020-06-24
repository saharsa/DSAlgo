package UpGrad;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePractice {

    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        int n = 0;
        while (n < arr.length){
            queue.add(arr[n]);
            n++;
        }
        //printFifthElementFromStart(queue);
        printFifthElementFromEnd(queue);
    }

    // Method to print the fifth element from the head of the queue
    static void printFifthElementFromStart(Queue<Integer> queue) {
        // Write your code here
        if(queue.size()<5){
            System.out.println("There are not enough elements in the queue");
            return;
        }
        int i=0;
        while(i<4){
            queue.remove();
            i++;
        }
        System.out.println(queue.peek());
    }

    static void printFifthElementFromEnd(Queue<Integer> queue) {
        // Write your code here
        if(queue.size()<5){
            System.out.println("There are not enough elements in the queue");
            return;
        }
        int i = queue.size() - 5;
        while(i>0){
            queue.remove();
            i--;
        }
        System.out.println(queue.peek());
    }
}
