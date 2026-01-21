package Queues.DinamicArray;
import StaticStructure.ArrayStructure;
import java.util.Arrays;

public class DinamicQueue<T> extends ArrayStructure<T> {

    public DinamicQueue(int capacity){
        super(capacity);
    }

    public DinamicQueue(){
        super();
    }

    public void enqueue(T element){
        super.add(element);
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
        size = 0;
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