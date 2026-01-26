package Queues.CircularQueue;
import StaticStructure.ArrayStructure;

public class CircularQueue<T> extends ArrayStructure<T> {
    private int end;
    private int start;

    public CircularQueue(int capacity){
        super(capacity);
        end = 0;
        start = 0;
    }

    public CircularQueue(){
        super();
        end = 0;
        start = 0;
    }

    //O(1)
    @Override
    public boolean isEmpty(){
        return end == start;
    }

    //O(1)
    @Override
    public boolean isFull(){
        return this.size == (this.elements.length - 1);
    }

    //O(1)
    public void enqueue(T element) throws RuntimeException {
        if(!isFull()){
            this.elements[end] = element;
            end = (end + 1) % this.elements.length;
            this.size++;
            return;
        }
        throw new RuntimeException("Queue is full");
    }

    //O(1)
    public T dequeue(){
        if(!isEmpty()){
            T removed = this.elements[start];
            start = (start + 1) % this.elements.length;
            this.size--;
            return removed;
        } return null;
    }

    //O(1)
    public T peek(){
        if(!isEmpty()){
            return this.elements[start];
        } return null;
    }

    //O(n)
    public void list() {
        System.out.println(this);
    }

    //O(1)
    public void clear(){
        end = 0;
        start = 0;
        this.elements[start] = null;
    }

    //O(n)
    public boolean contains(T element){
        for (int i = start; i < end; i++){
            if (element.equals(this.elements[i])){
                return true;
            }
        } return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        int current = start % elements.length;

        for (int i = 0; i < size; i++) {
            sb.append(elements[current]);
            if (i < size - 1) sb.append(", ");
            current = (current + 1) % elements.length;
        }

        return sb.append("]").toString();
    }
}