package Arrays;

public class Main {
    public static void main(String[] args) {
        Vector<String> names = new Vector<>(5);
        System.out.println("Vector is empty? " + names.isEmpty());
        names.add("Eduardo");
        names.add("Vanessa");
        names.add("Lucas");
        System.out.println("Vector is empty? " + names.isEmpty());
        names.add(1, "Nathalia");
        System.out.println(names);
        System.out.println(names.get(2));
        try {
            System.out.println(names.get(5));
        } catch (Exception e) {
            System.out.println(e);;
        }
        names.set(2, "Vanessa Silva");
        System.out.println(names);
        names.remove(3);
        System.out.println(names.indexOf("Nathalia"));
        names.remove("Lucas");
        System.out.println(names.remove("Jorge"));
        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.contains("Eduardo"));
        System.out.println(names.contains("Jorge"));
        System.out.println(names.getFirst());
        System.out.println(names.getLast());
        names.add("Eduardo");
        System.out.println(names.lastIndexOf("Eduardo"));
        System.out.println(names);
        names.clear();
        System.out.println(names);
    }
}