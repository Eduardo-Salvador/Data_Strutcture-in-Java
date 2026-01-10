package Recursion.DivideAndConquer;


public class ArraySum {
    public static Integer sum(Integer[] array) {
        int start = array[0];
        int sumNums = 0;
        if (!array[0].equals(array[array.length - 1])){
            //array[0] = array[];
            sumNums = start + sum(array);
        }
        return start + sumNums;
    }

    public static void main(String[] args) {
        Integer[] arrayBase = new Integer[]{0,1,2,3,4,5,6,7,8,9};
        Integer result = ArraySum.sum(arrayBase);
        System.out.println(result);

    }
}
