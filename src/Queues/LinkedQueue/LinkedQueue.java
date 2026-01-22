package Queues.LinkedQueue;
import DinamicStructure.NodeStructure;

import java.util.Arrays;

public class LinkedQueue<T> extends NodeStructure<T> {
    private Node<T> head;

    public LinkedQueue(){
        super();
        head = null;
    }

    public void enqueue(T element){
        if (isEmpty()){
            head = new Node<>(element);
            size++;
            return;
        }
        Node<T> newNode = new Node<>(element);
        Node<T> current = head;
        while (current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(newNode);
        size++;
    }

    public T dequeue(){
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        Node<T> removed = head;
        head = head.getNext();
        size--;
        return removed.getData();
    }

    public T peek(){
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        return head.getData();
    }

    public void list(){
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        Node<T> current = head;
        System.out.print("[");
        while (current.getNext() != null){
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
        System.out.print(current.getData());
        System.out.print("]\n");
    }

    public void clear(){
        if (isEmpty()){
            return;
        }
        for (Node<T> actual = head; actual != null;){
            Node<T> next = actual.getNext();
            actual.setData(null);
            actual.setNext(null);
            actual = next;
        }
        head = null;
        size = 0;
    }

    public boolean contains(T element){
        if (isEmpty()){
            return false;
        }
        Node<T> current = head;
        while (current != null){
            if (current.getData().equals(element)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null){
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
