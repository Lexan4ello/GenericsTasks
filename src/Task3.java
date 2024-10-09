import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Task3 {
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            R r = f.apply(t);
            newList.add(r);
        }

        return newList;
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 5, 3, 8);
        List<String> newStringList = map(integerList, String::valueOf);
        System.out.println(newStringList);

        List<Integer> stringLength = map(
                Arrays.asList("hello", "world", "!"),
                String::length
        );
        System.out.println(stringLength);
    }
}
