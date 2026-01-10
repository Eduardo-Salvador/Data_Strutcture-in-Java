package Recursion.DivideAndConquer;
import java.util.ArrayList;
import java.util.List;

public class ItemsInTheListArray {
    public static <T> Integer counterListElements(List<T> list, int index){
        if (index >= list.size()){
            return index;
        }
        return counterListElements(list, index + 1);
    }

    public static <T> Integer counterListElements(T[] array, int index){
        if (index >= array.length){
            return index;
        }
        return counterListElements(array, index + 1);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,1,2,3,4,2,5,2));
        Integer resultList = counterListElements(list, 0);

        String[] array = new String[]{"One", "Two", "Three", "Four"};
        Integer resultArray = counterListElements(array, 0);

        System.out.println("Elements in List: " + resultList);
        System.out.println("Elements in Array: " + resultArray);
    }
}