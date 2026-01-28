package OptimizationExercises.Stacks.Max_01;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Max_O1<Integer> minO1 = new Max_O1<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        minO1.push(10);
        minO1.push(34);
        minO1.push(32);
        minO1.push(12);
        minO1.push(56);
        minO1.push(3);
        minO1.push(321);
        minO1.push(49);
        minO1.push(23);

        System.out.println(minO1);

        System.out.println("Max: " + minO1.getMax());

        System.out.println(minO1.pop());
        System.out.println(minO1.pop());
        System.out.println(minO1.pop());
        System.out.println(minO1.pop());

        System.out.println(minO1);
        System.out.println("Max: " + minO1.getMax());

        System.out.println(minO1.pop());

        System.out.println(minO1);
        System.out.println("Max: " + minO1.getMax());
    }
}