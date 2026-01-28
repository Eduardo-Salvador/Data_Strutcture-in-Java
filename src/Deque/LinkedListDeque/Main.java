package Deque.LinkedListDeque;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedListDeque<Integer> doublyLinkedListDeque = new DoublyLinkedListDeque<>();
        doublyLinkedListDeque.addFirst(10);
        System.out.println(doublyLinkedListDeque);
        doublyLinkedListDeque.addFirst(20);
        System.out.println(doublyLinkedListDeque);
        doublyLinkedListDeque.addFirst(30);
        System.out.println(doublyLinkedListDeque);
        doublyLinkedListDeque.addFirst(40);
        System.out.println(doublyLinkedListDeque);
        doublyLinkedListDeque.addFirst(50);
        System.out.println(doublyLinkedListDeque);
        doublyLinkedListDeque.addFirst(60);
        System.out.println(doublyLinkedListDeque);
        doublyLinkedListDeque.addLast(61);
        System.out.println(doublyLinkedListDeque);
        doublyLinkedListDeque.addLast(62);
        System.out.println(doublyLinkedListDeque);

        System.out.println(doublyLinkedListDeque.removeFirst());
        System.out.println(doublyLinkedListDeque.removeFirst());
        System.out.println(doublyLinkedListDeque);
        System.out.println(doublyLinkedListDeque.removeLast());
        System.out.println(doublyLinkedListDeque.removeLast());
        System.out.println(doublyLinkedListDeque);

        System.out.println(doublyLinkedListDeque.getFirst());
        System.out.println(doublyLinkedListDeque.getLast());
        System.out.println(doublyLinkedListDeque.peekFirst());
        System.out.println(doublyLinkedListDeque.peekLast());

        System.out.println("Contains? 30 " + doublyLinkedListDeque.contains(30));
        System.out.println("Contains? 100 " + doublyLinkedListDeque.contains(100));

        System.out.println("Cleaning");
        doublyLinkedListDeque.clear();
        System.out.println(doublyLinkedListDeque);
    }
}
