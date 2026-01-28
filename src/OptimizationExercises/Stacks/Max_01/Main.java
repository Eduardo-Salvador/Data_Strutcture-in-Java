package OptimizationExercises.Stacks.Max_01;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Max_O1<Integer> max01 = new Max_O1<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        max01.push(10);
        max01.push(34);
        max01.push(32);
        max01.push(12);
        max01.push(56);
        max01.push(3);
        max01.push(321);
        max01.push(49);
        max01.push(23);

        System.out.println(max01);

        System.out.println("Max: " + max01.getMax());

        System.out.println(max01.pop());
        System.out.println(max01.pop());
        System.out.println(max01.pop());
        System.out.println(max01.pop());

        System.out.println(max01);
        System.out.println("Max: " + max01.getMax());

        System.out.println(max01.pop());

        System.out.println(max01);
        System.out.println("Max: " + max01.getMax());
    }
}