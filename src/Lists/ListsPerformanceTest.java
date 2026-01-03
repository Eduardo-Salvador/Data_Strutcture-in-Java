package Lists;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsPerformanceTest {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for(int i = 0; i < 1_000_000; i++){
            arrayList.add(i);
            linkedList.add(i);
        }

        long initialArray = System.currentTimeMillis();
        for(int i = 0; i < 1_000; i++){
            arrayList.get(i * 100);
        }
        long finishArray = System.currentTimeMillis();

        long initialLinked = System.currentTimeMillis();
        for(int i = 0; i < 1_000; i++){
            linkedList.get(i * 100);
        }
        long finishLinked = System.currentTimeMillis();

        System.out.println("ArrayList - Access Time: " + (finishArray - initialArray) + " ms");
        System.out.println("LinkedList - Access Time: " + (finishLinked - initialLinked) + " ms");
    }
}
