import java.lang.reflect.Array;
import java.util.Arrays;

public class Task2 {
    public static class GenericCollection<T> {
        private static final int DEFAULT_CAPACITY = 10;
        private final Class<?> typeClass;
        private int size;
        private T[] elements;

        /*@SuppressWarnings("unchecked")
        public GenericCollection() {
            elements = (T[]) new Object[DEFAULT_CAPACITY];
        }*/

        public GenericCollection(Class<?> typeClass) {
            this.typeClass = typeClass;
            elements = instanceArray(DEFAULT_CAPACITY);
        }

        public void add(T element) {
            if (size == elements.length) {
                resize(size * 2);
            }
            elements[size++] = element;
        }

        public void remove(int index) {
            checkArgument(index);

            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        }

        public T get(int index) {
            checkArgument(index);

            return elements[index];
        }

        private void checkArgument(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Incorrect capacity");
            }
        }

        public int size() {
            return size;
        }

        private void resize(int size) {
            T[] newElements = instanceArray(size);
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }

        @SuppressWarnings("unchecked")
        private T[] instanceArray(int size) {
            return (T[]) Array.newInstance(typeClass, size);
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(elements, size));
        }
    }

    public static void main(String[] args) {
        GenericCollection<String> genericCollection = new GenericCollection<>(String.class);
        for (int i = 0; i < 20; i++) {
            genericCollection.add(String.valueOf(i));
        }
        genericCollection.remove(7);
        System.out.println(genericCollection);
    }
}
