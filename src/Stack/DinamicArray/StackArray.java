package Stack.DinamicArray;

public class StackArray <T> {
    private T[] datas;
    private int top;
    private int size = 0;

    public StackArray(int capacity){
        datas = (T[]) new Object[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(T value){
        increaseCapacity();
        datas[++top] = value;
        size++;
    }

    public T pop(){
        if(top == -1){
            throw new RuntimeException("Underflow");
        }
        datas[top] = null;
        size--;
        return datas[top--];
    }

    public T peek(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return datas[top];
    }

    public int search(T element){
        if (!isEmpty()){
            for (int i = 0; i < datas.length; i++) {
                if (datas[i].equals(element)){
                    return top - i + 1;
                }
            }
        }
        return -1;
    }

    private void increaseCapacity(){
        if (size == datas.length) {
            T[] newElements = (T[]) new Object[datas.length * 2];
            for (int i = 0; i < datas.length; i++) {
                newElements[i] = datas[i];
            }
            datas = newElements;
        }
    }

    public int size(){
        return size;
    }

   @Override
    public String toString() {
        if (isEmpty()) return "Stack[]";

        StringBuilder sb = new StringBuilder("Stack [");
        for (int i = top; i >= 0; i--) {
            sb.append("\n").append(datas[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}