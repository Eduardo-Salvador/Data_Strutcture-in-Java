package Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Vector names = new Vector(5);
            names.add("Eduardo");
            names.add("Vanessa");
            names.add("Lucas");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}