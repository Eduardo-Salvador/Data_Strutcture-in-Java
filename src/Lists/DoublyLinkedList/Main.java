package Lists.DoublyLinkedList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i <= 30; i++) {
            doublyLinkedList.add("Element" + i);
        }
        System.out.println(doublyLinkedList);

        doublyLinkedList.addFirst("First Element");
        doublyLinkedList.addFirst("2x First Element");
        System.out.println(doublyLinkedList);

        doublyLinkedList.addLast("Last Element");
        doublyLinkedList.addLast("2x Last Element");
        System.out.println(doublyLinkedList);

        doublyLinkedList.add(10, ">>>>ELEMENT 10<<<<");
        doublyLinkedList.add(22, ">>>>ELEMENT 20<<<<");
        try {
            doublyLinkedList.add(40, "ELEMENT 10");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.remove());
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.remove(10));
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.remove("Element2"));
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.removeFirstOccurrence("Element14"));
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.removeLastOccurrence("Element4"));
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.get(3));
        System.out.println(doublyLinkedList.getFirst());
        System.out.println(doublyLinkedList.getLast());

        System.out.println(doublyLinkedList.contains("Element27"));
        System.out.println(doublyLinkedList.indexOf("Element23"));
        System.out.println(doublyLinkedList.indexOf("Element4"));
        System.out.println(doublyLinkedList.lastIndexOf("Element16"));

        System.out.println(doublyLinkedList.size());
        System.out.println(doublyLinkedList.isEmpty());

        String[] arrayString = doublyLinkedList.toArray(String.class);
        System.out.println("Array: " + Arrays.toString(arrayString));

        doublyLinkedList.clear();
        System.out.println(doublyLinkedList.size());
        System.out.println(doublyLinkedList);
    }
}