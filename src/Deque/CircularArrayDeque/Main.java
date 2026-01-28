package Deque.CircularArrayDeque;

public class Main {
    public static void main(String[] args) {
        CircularArrayDeque<Integer> circularArrayDeque = new CircularArrayDeque<>(20);
        circularArrayDeque.addFirst(10);
        System.out.println(circularArrayDeque);
        circularArrayDeque.addFirst(20);
        System.out.println(circularArrayDeque);
        circularArrayDeque.addFirst(30);
        System.out.println(circularArrayDeque);
        circularArrayDeque.addFirst(40);
        System.out.println(circularArrayDeque);
        circularArrayDeque.addFirst(50);
        System.out.println(circularArrayDeque);
        circularArrayDeque.addFirst(60);
        System.out.println(circularArrayDeque);
        circularArrayDeque.addLast(61);
        System.out.println(circularArrayDeque);
        circularArrayDeque.addLast(62);
        System.out.println(circularArrayDeque);

        System.out.println(circularArrayDeque.removeFirst());
        System.out.println(circularArrayDeque.removeFirst());
        System.out.println(circularArrayDeque);
        System.out.println(circularArrayDeque.removeLast());
        System.out.println(circularArrayDeque.removeLast());
        System.out.println(circularArrayDeque);

        System.out.println(circularArrayDeque.getFirst());
        System.out.println(circularArrayDeque.getLast());
        System.out.println(circularArrayDeque.peekFirst());
        System.out.println(circularArrayDeque.peekLast());

        System.out.println("Contains? 30 " + circularArrayDeque.contains(30));
        System.out.println("Contains? 100 " + circularArrayDeque.contains(100));

        System.out.println("Cleaning");
        circularArrayDeque.clear();
        System.out.println(circularArrayDeque);
    }
}