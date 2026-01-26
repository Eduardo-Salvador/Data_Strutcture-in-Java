package Lists.DoublyLinkedCircularList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedCircularList<String> doublyLinkedList = new DoublyLinkedCircularList<>();
        System.out.println(doublyLinkedList);
        for (int i = 0; i < 20; i++) {
            doublyLinkedList.addLast("Element " + i);
        }
        System.out.println(doublyLinkedList);

        doublyLinkedList.add(3, ">>EXTRA ELEMENT<<");
        System.out.println(doublyLinkedList);

        doublyLinkedList.addFirst(">>EXTRA FIRST ELEMENT<<");
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.get(5));

        System.out.println(doublyLinkedList.getFirst());

        doublyLinkedList.set(0, ">>NEW FIRST ELEMENT<<");
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.remove(3));
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.remove("Element 0"));
        System.out.println(doublyLinkedList);

        System.out.println("Contains Element 2? " + doublyLinkedList.contains("Element 2"));
        System.out.println("Contains Element 0? " + doublyLinkedList.contains("Element 0"));

        System.out.println("Index of Element 6? " + doublyLinkedList.indexOf("Element 6"));
        System.out.println("Index of Element 0? " + doublyLinkedList.indexOf("Element 0"));

        System.out.println("Cleaning");
        doublyLinkedList.clear();
        System.out.println(doublyLinkedList);
    }
}