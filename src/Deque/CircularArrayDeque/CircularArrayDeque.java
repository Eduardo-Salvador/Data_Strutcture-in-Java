package Deque.CircularArrayDeque;
import StaticStructure.ArrayStructure;
import java.util.NoSuchElementException;

public class CircularArrayDeque<T> extends ArrayStructure<T> {
    private int end;
    private int start;

    public CircularArrayDeque(int capacity){
        super(capacity);
        end = 0;
        start = 0;
    }

    public CircularArrayDeque(){
        super();
        end = 0;
        start = 0;
    }

    //O(1)
    public void addFirst(T element) throws RuntimeException {
        if (!isFull()) {
            start = (start - 1 + this.elements.length) % this.elements.length;
            this.elements[start] = element;
            this.size++;
            return;
        }
        throw new RuntimeException("Queue is full");
    }

    //O(1)
    public void addLast(T element) throws RuntimeException {
        if (!isFull()) {
            this.elements[end] = element;
            end = (end + 1) % this.elements.length;
            this.size++;
            return;
        }
        throw new RuntimeException("Queue is full");
    }

    //O(1)
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T removed = this.elements[start];
        start = (start + 1) % this.elements.length;
        this.size--;
        return removed;
    }

    //O(1)
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        end = (end - 1 + this.elements.length) % this.elements.length;
        T removed = elements[end];
        this.size--;
        return removed;
    }

    //O(1)
    public T getFirst() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        return this.elements[start];
    }

    //O(1)
    public T getLast() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        return this.elements[(end - 1 + this.elements.length) % this.elements.length];
    }

    //O(1)
    public T peekFirst(){
        if (isEmpty()){
            return null;
        }
        return this.elements[start];
    }

    //O(1)
    public T peekLast(){
        if (isEmpty()){
            return null;
        }
        return this.elements[(end - 1 + this.elements.length) % this.elements.length];
    }

    //O(n)
    public boolean contains(T element){
        if(isEmpty()){
            return false;
        }
        if (element == null){
            return false;
        }
        for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % elements.length) {
            if (element.equals(this.elements[idx])){
                return true;
            }
        }
        return false;
    }

    //O(1)
    public void clear(){
        start = 0;
        end = 0;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % elements.length) {
            sb.append(elements[idx]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}