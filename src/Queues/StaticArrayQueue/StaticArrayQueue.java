package Queues.StaticArrayQueue;
import StaticStructure.ArrayStructure;
import java.util.Arrays;

public class StaticArrayQueue<T> extends ArrayStructure<T> {

    public StaticArrayQueue(int capacity){
        super(capacity);
    }

    public StaticArrayQueue(){
        super();
    }

    public void enqueue(T element){
        if(isFull()){
            throw new RuntimeException("Queue is Full");
        }
        elements[size] = element;
        this.size++;
    }

    public T dequeue(){
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        T elementRemoved = elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return elementRemoved;
    }

    public T peek(){
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        return elements[0];
    }

    public void list(){
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        System.out.println(this);
    }

    public void clear(){
        if (isEmpty()){
            return;
        }
        Arrays.fill(elements, null);
        this.size = 0;
    }

    public boolean contains(T element){
        if (isEmpty()){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }
}