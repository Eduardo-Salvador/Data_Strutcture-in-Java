package Queues.PriorityQueue;
import Queues.DinamicArray.DinamicQueue;

public class PriorityQueue<T> extends DinamicQueue<T> {

    public PriorityQueue(int capacity){
        super(capacity);
    }

    public PriorityQueue(){
        super();
    }

    @SuppressWarnings("unchecked")
    public void enqueue(T element){
        Comparable<T> key = (Comparable<T>) element;
        int i;
        for(i = 0; i < size; i++){
            if(key.compareTo(elements[i]) < 0){
                break;
            }
        }
        this.add(i, element);
    }
}