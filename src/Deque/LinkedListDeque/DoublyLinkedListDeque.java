package Deque.LinkedListDeque;
import DinamicStructure.NodeStructure;
import java.util.NoSuchElementException;

public class DoublyLinkedListDeque<T> extends NodeStructure<T> {
    private Node<T> start;
    private Node<T> end;

    public DoublyLinkedListDeque(){
        super();
        start = null;
        end = null;
    }

    //O(1)
    public void addFirst(T element) throws RuntimeException {
        Node<T> newNode = new Node<>(element);
        if(isEmpty()) {
            start = newNode;
            end = newNode;
            this.size++;
            return;
        }
        start.setPrevious(newNode);
        newNode.setNext(start);
        start = newNode;
        this.size++;
    }

    //O(1)
    public void addLast(T element) throws RuntimeException{
        Node<T> newNode = new Node<>(element);
        if(isEmpty()) {
            addFirst(newNode.getData());
            return;
        }
        end.setNext(newNode);
        newNode.setPrevious(end);
        end = newNode;
        this.size++;
    }

    //O(1)
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T removed = start.getData();
        if (this.size == 1) {
            start = null;
            end = null;
            this.size--;
            return removed;
        }
        start = start.getNext();
        start.setPrevious(null);
        this.size--;
        return removed;
    }

    //O(1)
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T removed = end.getData();
        if (this.size == 1) {
            start = null;
            end = null;
            this.size--;
            return removed;
        }
        end = end.getPrevious();
        end.setNext(null);
        this.size--;
        return removed;
    }

    //O(1)
    public T getFirst() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        return start.getData();
    }

    //O(1)
    public T getLast() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        return end.getData();
    }

    //O(1)
    public T peekFirst() {
        if (isEmpty()){
            return null;
        }
        return start.getData();
    }

    //O(1)
    public T peekLast(){
        if (isEmpty()){
            return null;
        }
        return end.getData();
    }

    //O(n)
    public boolean contains(T element){
        if(isEmpty()){
            return false;
        }
        if (element == null) {
            return false;
        }
        Node<T> current = start;
        while (current != null) {
            if(current.getData().equals(element)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    //O(1)
    public void clear(){
        start = null;
        end = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = start;
        int i = 0;
        while (current != null) {
            sb.append(current.getData());
            if (i < size - 1) {
                sb.append(", ");
            }
            i++;
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}