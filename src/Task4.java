import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static class Box<T extends Comparable<T>>{
        private final List<T> list = new ArrayList<>();

        public void add(T item) {
            list.add(item);
        }

        public void sort() {
            list.sort(Comparable::compareTo);
        }

        @Override
        public String toString() {
            return "Box{" +
                    "list=" + list +
                    '}';
        }
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.add(10);
        box.add(7);
        box.add(1);
        box.add(4);

        box.sort();
        System.out.println(box);
    }
}
