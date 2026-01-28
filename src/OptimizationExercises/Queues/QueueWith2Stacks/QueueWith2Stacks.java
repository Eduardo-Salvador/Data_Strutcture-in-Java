package OptimizationExercises.Queues.QueueWith2Stacks;
import OptimizationExercises.Stacks.Max_01.Max_O1;
import OptimizationExercises.Stacks.Min_01.Min_O1;
import Queues.DinamicArrayQueue.DinamicArrayQueue;

import java.util.Comparator;

public class QueueWith2Stacks<T extends Comparable<T>> extends DinamicArrayQueue<T> {
    private Min_O1<T> inStackMin;
    private Max_O1<T> inStackMax;
    private Min_O1<T> outStackMin;
    private Max_O1<T> outStackMax;

    public QueueWith2Stacks(){
        super();
        initializeStacks();
    }

    public QueueWith2Stacks(int capacity){
        super(capacity);
        initializeStacks();
    }

    //O(1)
    private void initializeStacks() {
        Comparator<T> comparator = Comparator.naturalOrder();
        inStackMin = new Min_O1<>(comparator);
        inStackMax = new Max_O1<>(comparator);
        outStackMin = new Min_O1<>(comparator);
        outStackMax = new Max_O1<>(comparator);
    }

    //O(1)
    private void transfer() {
        while (!inStackMin.isEmpty()) {
            T element = inStackMin.pop();
            inStackMax.pop();
            outStackMin.push(element);
            outStackMax.push(element);
        }
    }

    //O(1)
    @Override
    public void enqueue(T element){
        inStackMin.push(element);
        inStackMax.push(element);
    }

    //O(1)
    @Override
    public T dequeue(){
        if(outStackMin.isEmpty()){
            transfer();
        }
        T element = outStackMin.pop();
        outStackMax.pop();
        return element;
    }

    //O(1)
    public T getMin() {
        if (outStackMin.isEmpty()) {
            return inStackMin.getMin();
        }
        if (inStackMin.isEmpty()) {
            return outStackMin.getMin();
        }
        T minIn = inStackMin.getMin();
        T minOut = outStackMin.getMin();
        return minIn.compareTo(minOut) < 0 ? minIn : minOut;
    }

    //O(1)
    public T getMax() {
        if (outStackMax.isEmpty()) {
            return inStackMax.getMax();
        }
        if (inStackMax.isEmpty()) {
            return outStackMax.getMax();
        }
        T maxIn = inStackMax.getMax();
        T maxOut = outStackMax.getMax();
        return maxIn.compareTo(maxOut) > 0 ? maxIn : maxOut;
    }
}