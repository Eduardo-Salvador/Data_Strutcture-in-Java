package OptimizationExercises.Deques.SlidingWindow;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SlidingWindow<T> extends ArrayDeque<T> {
    //O(n)
    public void slidingWindow(int[] arr, int k) throws NoSuchElementException {
        ArrayDeque<Integer> aux = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if(arr.length < 3){
            throw new NoSuchElementException("Min 3 elements in array");
        }
        for (int i = 0; i < arr.length; i++) {
            //Check if the index is within the valid window.
            while (!aux.isEmpty() && aux.peekFirst() < i - k + 1){
                aux.removeFirst();
            }
            /*
            It compares whether the last element in the monotonic deque is greater than the next element in the window,
            thus keeping the first element of the monotonic deque always the largest to be added to the result.
            */
            while (!aux.isEmpty() && arr[aux.peekLast()] < arr[i]){
                aux.removeLast();
            }
            aux.addLast(i);
            if(i >= k - 1){
                result.add(arr[aux.peekFirst()]);
            }
        }
        System.out.println("Result: " + result);
    }
}