package OptimizationExercises.Deques.SlidingWindow;

public class Main {
    public static void main(String[] args) {
        SlidingWindow<Integer> slidingWindow = new SlidingWindow<>();
        int[] arr = new int[]{3,-1, 2, 5, 2, -2, 9};
        slidingWindow.slidingWindow(arr, 3);
    }
}