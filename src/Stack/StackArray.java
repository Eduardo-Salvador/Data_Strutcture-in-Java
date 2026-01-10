package Stack;

public class StackArray {

    private int[] datas;
    private int top;

    public StackArray(int capacity){
        datas = new int[capacity];
        top = -1;
    }

    public void push(int value){
        if(top == datas.length - 1){
            throw new RuntimeException("Overflow");
        }
        datas[++top] = value;
    }

    public int pop(){
        if(top == -1){
            throw new RuntimeException("Underflow");
        }
        return datas[top--];
    }

    public int peek(){
        return datas[top];
    }
}
