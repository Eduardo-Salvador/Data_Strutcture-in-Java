package Lists.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<>();
        System.out.println("is Empty? " + arrayList.isEmpty());
        arrayList.add(10.1);
        arrayList.add(10.2);
        arrayList.add(10.3);
        arrayList.add(10.4);
        arrayList.add(10.5);
        arrayList.add(10.6);
        arrayList.add(10.7);
        arrayList.add(10.8);
        arrayList.add(10.9);
        arrayList.add(10.10);
        System.out.println("is Empty? " + arrayList.isEmpty());
        System.out.println(arrayList);
        arrayList.add(10.11);
        arrayList.add(10.12);
        arrayList.add(4, 10.33);
        System.out.println(arrayList);
        System.out.println(arrayList.get(4));
        System.out.println(arrayList.remove(11));
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.remove(10.5));
        arrayList.set(2, 10.22);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.contains(10.7));
        System.out.println(arrayList.indexOf(10.10));
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println("is Empty? " + arrayList.isEmpty());
        arrayList.resize(40);
        arrayList.add(10D);
        System.out.println(arrayList.removeFirst());
        System.out.println(arrayList);
        arrayList.add(11D);
        arrayList.add(12D);
        arrayList.add(13D);
        System.out.println(arrayList);
        System.out.println(arrayList.removeLast());
        System.out.println(arrayList);

    }
}