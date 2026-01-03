package Arrays;

public class Vector {
    private String[] elements;
    private int size;

    public Vector(final int capacity) {
        this.elements = new String[capacity];
        this.size = 0;
    }

    public void add(final String e) {
       increaseCapacity();
       if (size < elements.length) {
           elements[size] = e;
           size++;
       }
    }

    private void increaseCapacity(){
        if (size == elements.length) {
            String[] newElements = new String[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
}