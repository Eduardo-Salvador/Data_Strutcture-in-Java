package Recursion.DivideAndConquer;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static Integer helper(Integer[] array, Integer elementSearch, int start, int end, int counter){
        counter++;
        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) / 2);
        if (array[mid].equals(elementSearch)) {
            return mid;
        }

        if (elementSearch > array[mid]) {
            return helper(array, elementSearch, mid + 1, end, counter);
        }
        return helper(array, elementSearch, start, mid - 1, counter);
    }

    public static Integer binarySearch(Integer[] array, Integer elementSearch){
        return helper(array, elementSearch, 0, array.length - 1, 0);
    }

    public static void main(String[] args) {
        Random random = new Random();
        Integer[] array = new Integer[1_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100_000);
        }
        Arrays.sort(array);
        int elementSearch = array[array.length - 1];

        //Heating JVM
        for (int i = 0; i < 100; i++) {
            binarySearch(array, elementSearch);
        }

        long startBinarySearch = System.nanoTime();
        Integer result = binarySearch(array, elementSearch);
        long finishBinarySearch = System.nanoTime();

        long startLinearSearch = System.nanoTime();
        for (Integer integer : array) {
            if (integer == elementSearch) {
                break;
            }
        }
        long finishLinearSearch = System.nanoTime();

        System.out.println("Binary Search Time O(logN): " + (finishBinarySearch - startBinarySearch)/1000 + " μs");
        System.out.println("Linear Search Time O(n): " + (finishLinearSearch - startLinearSearch)/1000 + " μs");
    }
}