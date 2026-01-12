package Queues.StaticArray;
import java.util.Arrays;

public class StaticQueue <T> {
    private T[] datas;
    private int size = 0;

    public StaticQueue(int capacity){
        datas = (T[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == datas.length;
    }

    public void enqueue(T element){
        if (isFull()){
            throw new RuntimeException("Overflow");
        }
        datas[size] = element;
        size++;
    }

    public T dequeue(){
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        T elementRemoved = datas[0];
        for (int i = 0; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        datas[size - 1] = null;
        size--;
        return elementRemoved;
    }

    public T peek(){
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        return datas[0];
    }

    public void list(){
        if(isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        for (int i = 0; i < size; i++) {
            System.out.println(datas[i]);
        }
    }

    public int size(){
        return size;
    }

    public void clear(){
        if (isEmpty()){
            return;
        }
        size = 0;
        for (int i = 0; i < datas.length; i++) {
            datas[i] = null;
        }
    }

    public boolean contains(T element){
        if (isEmpty()){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (datas[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "StaticQueue{" +
                "datas=" + Arrays.toString(datas) +
                ", size=" + size +
                '}';
    }
}