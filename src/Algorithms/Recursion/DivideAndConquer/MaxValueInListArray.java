package Algorithms.Recursion.DivideAndConquer;
import java.util.ArrayList;
import java.util.List;

public class MaxValueInListArray {
    public static Integer max(List<Integer> list, int index, Integer maxValue){
        if (index >= list.size()){
            return maxValue;
        }
        if (list.get(index) > maxValue){
            maxValue = list.get(index);
        }
        return max(list, (index + 1), maxValue);
    }

    public static Integer max(Integer[] array, int index, Integer maxValue){
        if (index >= array.length){
            return maxValue;
        }
        if (array[index] > maxValue){
            maxValue = array[index];
        }
        return max(array, (index + 1), maxValue);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9,11,23,42,12));
        Integer resultList = max(list, 0, 0);

        Integer[] array = new Integer[]{0,1,44,23,192,321,4,2,1,1};
        Integer resultArray = max(array, 0, 0);

        System.out.println("Max in List: " + resultList);
        System.out.println("Max in Array: " + resultArray);
    }
}