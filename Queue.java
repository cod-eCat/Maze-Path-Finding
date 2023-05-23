package com.lpa.graph;

    /*
    Author @LwinPhyoAung
     */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T>{

    private class Node{
        private T e;
        private Node next;
        private Node(T e){
            this.e=e;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    public Queue(){

    }

    public void enqueue(T e){
        Node node=new Node(e);
        if (size==0){
            head=node;
            tail=node;
            size+=1;
            return;
        }
        tail.next=node;
        tail=node;
        size+=1;
    }

    public T dequeue(){
        if (size==0) throw new NoSuchElementException();
        T e = head.e;
        head=head.next;
        size-=1;
        return e;
    }

    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public Iterator<T> iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator<T>{

        private Node current=head;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T e = current.e;
            current=current.next;
            return e;
        }
    }

}
