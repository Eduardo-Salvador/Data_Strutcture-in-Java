package OptimizationExercises.Stacks.Min_01;
import Stack.DinamicArray.StackDinamicArray;
import java.util.Comparator;

public class Min_O1 <T> extends StackDinamicArray<T> {
    private final StackDinamicArray<T> minStack = new StackDinamicArray<>();
    private final Comparator<T> comparator;

    public Min_O1(int capacity, Comparator<T> comparator){
        super(capacity);
        this.comparator = comparator;
    }

    public Min_O1(Comparator<T> comparator){
        super();
        this.comparator = comparator;
    }

    //O(1) or O(n) If you use the method increaseCapacity
    @Override
    public void push(T element) throws IndexOutOfBoundsException {
        if (minStack.isEmpty() || comparator.compare(element, minStack.peek()) <= 0){
            minStack.push(element);
        }
        super.push(element);
    }

    //O(1)
    @Override
    public T pop(){
        if (this.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return super.pop();
    }

    //O(1)
    public T getMin(){
        return minStack.peek();
    }
}