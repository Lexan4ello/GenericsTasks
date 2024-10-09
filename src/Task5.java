import java.util.Arrays;
import java.util.function.IntFunction;

public class Task5 {
    static class Container<T> {
        static final int DEFAULT_CAPACITY = 10;
        private final T[] array;
        private int counter;

        public Container(IntFunction<T[]> arrayCreator) {
            array = genericArray(arrayCreator);
        }

        public void addItem(T item) {
            array[counter++] = item;
        }

        public T getItem(int index) {
            return array[index];
        }

        public String getAll() {
            return Arrays.toString(array);
        }

        public boolean contains(T element) {
            return Arrays.binarySearch(array, element) >= 0;
        }

        private static <T> T[] genericArray(IntFunction<T[]> arrayCreator) {
            return arrayCreator.apply(DEFAULT_CAPACITY);
        }
    }

    public static void main(String[] args) {
        Container<Integer> container = new Container<>(Integer[]::new);
        for (int i = 0; i < 10; i++) {
            container.addItem(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(container.getItem(i));
        }

        System.out.println(container.getAll());
        System.out.println(container.contains(10));
        System.out.println(container.contains(9));

    }
}
