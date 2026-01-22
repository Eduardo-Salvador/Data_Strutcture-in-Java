package Lists.LinkedList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList<Double> linkedList = new LinkedList<>();
        System.out.println("is Empty? " + linkedList.isEmpty());
        linkedList.addLast(10.1);
        linkedList.addLast(10.2);
        linkedList.addLast(10.3);
        linkedList.addLast(10.4);
        linkedList.addLast(10.5);
        linkedList.addLast(10.6);
        linkedList.addLast(10.7);
        linkedList.addLast(10.8);
        linkedList.addLast(10.9);
        linkedList.addLast(10.10);
        System.out.println("is Empty? " + linkedList.isEmpty());
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        linkedList.addFirst(10.11);
        System.out.println(linkedList.getFirst());
        linkedList.addFirst(10.12);
        System.out.println(linkedList.getFirst());
        linkedList.add(4, 10.33);
        System.out.println(linkedList);
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.remove(11));
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        System.out.println(linkedList.remove(10.5));
        linkedList.set(2, 10.22);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        System.out.println(linkedList.contains(10.7));
        System.out.println(linkedList.indexOf(10.10));
        Double[] doubleArray = linkedList.toArray(Double.class);
        System.out.println("Array: " + Arrays.toString(doubleArray));
        linkedList.clear();
        System.out.println(linkedList);
        System.out.println("is Empty? " + linkedList.isEmpty());
        System.out.println(linkedList.size());
    }
}