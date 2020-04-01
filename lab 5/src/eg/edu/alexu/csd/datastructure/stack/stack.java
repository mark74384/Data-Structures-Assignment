package eg.edu.alexu.csd.datastructure.stack;

import java.util.LinkedList;
import java.util.Scanner;

public class stack implements IStack {
    LinkedList <Object> list = new LinkedList<Object>();
    private int size =0 ;
    public class Node {
        private Object data;
        private Node next;
    }

    Node top;
    public void setTop (){
        this.top = null;
    }

    @Override
    public Object pop() {
        if (top == null){
            throw new RuntimeException();
        }
        else {
            Node temp = top;
            top = top.next;
            size--;
            return temp.data;
        }
    }

    @Override
    public Object peek() {
        if (top == null){
            throw new RuntimeException();
        }
        else{
            return top.data;
        }
    }

    @Override
    public void push(Object element) {
        Node temp = new Node();
        temp.data = element;
        temp.next = top;
        top = temp;
        size++;
    }

    @Override
    public boolean isEmpty() {
        if (top == null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

}