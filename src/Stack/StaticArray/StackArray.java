package Stack.StaticArray;

public class StackArray <T> {
    private T[] datas;
    private int top;

    public StackArray(int capacity){
        datas = (T[]) new Object[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(T value){
        if(top == datas.length - 1){
            throw new RuntimeException("Overflow");
        }
        datas[++top] = value;
    }

    public T pop(){
        if(top == -1){
            throw new RuntimeException("Underflow");
        }
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