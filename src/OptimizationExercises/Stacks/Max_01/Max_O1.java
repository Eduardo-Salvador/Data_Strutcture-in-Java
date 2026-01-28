package OptimizationExercises.Stacks.Max_01;
import Stack.DinamicArray.StackDinamicArray;
import java.util.Comparator;

public class Max_O1<T> extends StackDinamicArray<T> {
    private final StackDinamicArray<T> maxStack = new StackDinamicArray<>();
    private final Comparator<T> comparator;

    public Max_O1(int capacity, Comparator<T> comparator){
        super(capacity);
        this.comparator = comparator;
    }

    public Max_O1(Comparator<T> comparator){
        super();
        this.comparator = comparator;
    }

    //O(1) or O(n) If you use the method increaseCapacity
    @Override
    public void push(T element) throws IndexOutOfBoundsException {
        if (maxStack.isEmpty() || comparator.compare(element, maxStack.peek()) >= 0){
            maxStack.push(element);
        }
        super.push(element);
    }

    //O(1)
    @Override
    public T pop(){
        if (this.peek().equals(maxStack.peek())){
            maxStack.pop();
        }
        return super.pop();
    }

    //O(1)
    public T getMax(){
        return maxStack.peek();
    }
}