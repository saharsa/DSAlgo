package UpGrad;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedListStack<T> {

    public static void main(String[] args) {
        LinkedListStack<Integer> list = new LinkedListStack<>();
        list.push(1);
        list.push(5);
        try{
            while(true){
                System.out.println("Popped="+list.pop());
            }
        }catch(Exception e){
            System.out.println("All Done!");
        }
    }

    private LinkedList<T> stack = new LinkedList<>();

    public void push(T element){
        this.stack.add(element);
    }

    public T pop()throws EmptyStackException{
        if(this.stack.size()>0){
            T e = this.stack.get(this.stack.size()-1);
            this.stack.remove(this.stack.size()-1);
            return e;
        }
        throw new EmptyStackException();
    }

    public T peek(){
        if(this.stack.size()>0){
            T e = this.stack.get(this.stack.size()-1);
            return e;
        }
        return null;
    }

    public boolean isEmpty(){
        return this.stack.size()==0;
    }
}
