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

    //O(1)
    public void enqueue(T element) throws RuntimeException{
        if(isFull()){
            throw new RuntimeException("Queue is Full");
        }
        elements[size] = element;
        this.size++;
    }

    //O(n)
    public T dequeue(){
        if(isEmpty()) {
            return null;
        }
        T elementRemoved = elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return elementRemoved;
    }

    //O(1)
    public T peek(){
        if(isEmpty()) {
            return null;
        }
        return elements[0];
    }

    //O(n)
    public void list() throws RuntimeException {
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        System.out.println(this);
    }

    //O(n), but is possible O(1)
    public void clear(){
        if (isEmpty()){
            return;
        }
        Arrays.fill(elements, null);
        this.size = 0;
    }

    //O(n)
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