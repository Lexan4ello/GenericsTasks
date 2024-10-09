import java.io.*;
import java.util.Arrays;

public class Task6 {
    public static class DataHolder<T> implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
        private final T[] data;

        public DataHolder(T[] data) {
            this.data = data;
        }

        public void save(String fileName) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                objectOutputStream.writeObject(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void load(String fileName) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                @SuppressWarnings("unchecked") T[] data = (T[]) objectInputStream.readObject();
                System.out.println(Arrays.toString(data));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "DataHolder{" +
                    "data=" + Arrays.toString(data) +
                    '}';
        }
    }

    public static void main(String[] args) {
        String fileName = "data.bin";
        DataHolder<String> dataHolder = new DataHolder<>(new String[]{"hello", "world", "goodbye", "world"});
        dataHolder.save(fileName);
        dataHolder.load(fileName);
    }
}
