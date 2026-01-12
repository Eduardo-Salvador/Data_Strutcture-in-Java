package Stack.List;
import java.util.ArrayList;
import java.util.List;

public class StackList<T> {
    private List<T> datas;

    public StackList(){
        datas = new ArrayList<>();
    }

    public boolean isEmpty(){
        return datas.isEmpty();
    }

    public void push(T value){
        datas.add(value);
    }

    public T pop(){
        if (isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        T valuePop = datas.get(datas.size() - 1);
        datas.remove(datas.size() - 1);
        return valuePop;
    }

    public T peek(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return datas.getLast();
    }

    public int search(T element){
        if (!isEmpty()){
            for (int i = 0; i < datas.size(); i++) {
                if (datas.get(i).equals(element)){
                    return datas.size() - i;
                }
            }
        }
        return -1;
    }

    public int size(){
        return datas.size();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Stack[]";

        StringBuilder sb = new StringBuilder("Stack [");
        for (int i = datas.size() - 1; i >= 0; i--) {
            sb.append("\n").append(datas.get(i));
            if (i > 0) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}