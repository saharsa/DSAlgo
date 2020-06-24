package UpGrad;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueSort {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(6);
        queue.add(12);
        queue.add(3);
        queue.add(5);
        queue.add(4);
        queue.add(1);
        queue.add(7);
        queue.add(8);
        queue.add(10);
        queue.add(9);
        queue.add(11);
        queue.add(2);
        sort(queue);
    }

    static void sort(Queue<Integer> queue) {
        // Write your code here
        Queue<Integer> sortedQueue = new LinkedList<>();
        while(!queue.isEmpty()){
            int temp = queue.remove();
            while(!sortedQueue.isEmpty() && sortedQueue.peek()>temp){
                queue.add(sortedQueue.remove());
            }
            int size = sortedQueue.size();
            while(size>0){
                int pop = sortedQueue.remove();
                if(pop>temp){
                    queue.add(pop);
                }else{
                    sortedQueue.add(pop);
                }
                size--;
            }
            sortedQueue.add(temp);
        }
        System.out.println(sortedQueue);
    }
}
