package Queues.LinkedQueue;
import DinamicStructure.NodeStructure;

public class LinkedQueue<T> extends NodeStructure<T> {
    private Node<T> head;

    public LinkedQueue(){
        super();
        head = null;
    }

    //O(n)
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

    //O(1)
    public T dequeue()  {
        if(isEmpty()) {
            return null;
        }
        Node<T> removed = head;
        head = head.getNext();
        size--;
        return removed.getData();
    }

    //O(1)
    public T peek(){
        if(isEmpty()) {
            return null;
        }
        return head.getData();
    }

    //O(n)
    public void list() throws RuntimeException {
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

    //O(n), but is possible O(1)
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

    //O(n)
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