package Recursion.DivideAndConquer;


public class ArraySum {
    private static Integer sumHelper(Integer[] array, int index){
        if(index >= array.length){
            return 0;
        }
        return array[index] + sumHelper(array, index + 1);
    }

    public static Integer sum(Integer[] array) {
        return sumHelper(array, 0);
    }

    public static void main(String[] args) {
        Integer[] arrayBase = new Integer[]{0,1,2,3,4,5,6,7,8,9};
        Integer result = ArraySum.sum(arrayBase);
        System.out.println("Array Sum: " + result);
    }
}