package Lists.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Double> linkedList = new LinkedList<>();
        System.out.println("is Empty? " + linkedList.isEmpty());
        linkedList.add(10.1);
        linkedList.add(10.2);
        linkedList.add(10.3);
        linkedList.add(10.4);
        linkedList.add(10.5);
        linkedList.add(10.6);
        linkedList.add(10.7);
        linkedList.add(10.8);
        linkedList.add(10.9);
        linkedList.add(10.10);
        System.out.println("is Empty? " + linkedList.isEmpty());
        System.out.println(linkedList);
        linkedList.add(10.11);
        linkedList.add(10.12);
        linkedList.add(4, 10.33);
        System.out.println(linkedList);
        System.out.println(linkedList.get(4));
        linkedList.remove(11);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        linkedList.remove(10.5);
        linkedList.set(2, 10.22);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        System.out.println(linkedList.contains(10.7));
        System.out.println(linkedList.indexOf(10.10));
        linkedList.clear();
        System.out.println(linkedList);
        System.out.println("is Empty? " + linkedList.isEmpty());
    }
}