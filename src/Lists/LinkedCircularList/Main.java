package Lists.LinkedCircularList;

public class Main {
    public static void main(String[] args) {
        LinkedCircularList<String> linkedCircularList = new LinkedCircularList<>();
        System.out.println(linkedCircularList);
        for (int i = 0; i < 20; i++) {
            linkedCircularList.addLast("Element " + i);
        }
        System.out.println(linkedCircularList);

        linkedCircularList.add(3, ">>EXTRA ELEMENT<<");
        System.out.println(linkedCircularList);

        linkedCircularList.addFirst(">>EXTRA FIRST ELEMENT<<");
        System.out.println(linkedCircularList);

        System.out.println(linkedCircularList.get(5));

        System.out.println(linkedCircularList.getFirst());

        linkedCircularList.set(0, ">>NEW FIRST ELEMENT<<");
        System.out.println(linkedCircularList);

        System.out.println(linkedCircularList.removeFirst());
        System.out.println(linkedCircularList);

        System.out.println(linkedCircularList.removeLast());
        System.out.println(linkedCircularList);

        System.out.println(linkedCircularList.remove(3));
        System.out.println(linkedCircularList);

        System.out.println(linkedCircularList.remove("Element 0"));
        System.out.println(linkedCircularList);

        System.out.println("Contains Element 2? " + linkedCircularList.contains("Element 2"));
        System.out.println("Contains Element 0? " + linkedCircularList.contains("Element 0"));

        System.out.println("Index of Element 6? " + linkedCircularList.indexOf("Element 6"));
        System.out.println("Index of Element 0? " + linkedCircularList.indexOf("Element 0"));

        System.out.println("Cleaning");
        linkedCircularList.clear();
        System.out.println(linkedCircularList);
    }
}