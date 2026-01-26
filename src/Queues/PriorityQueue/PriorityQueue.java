package Queues.PriorityQueue;
import Queues.DinamicArrayQueue.DinamicArrayQueue;

public class PriorityQueue<T> extends DinamicArrayQueue<T> {

    public PriorityQueue(int capacity){
        super(capacity);
    }

    public PriorityQueue(){
        super();
    }

    //O(logN) in the literature (HEAP), in the example it is O(n) because it does not implement the Heap.
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