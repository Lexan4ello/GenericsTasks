public class Task1 {
    public static class Pair<K, V> {
        private final K k;
        private final V v;

        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public Pair<V, K> swapItems() {
            return new Pair<>(v, k);
        }
        public static <K, V> Pair<V, K> swapItems(Pair<K, V> pair) {
            return new Pair<>(pair.v, pair.k);
        }

        public K getFirst() {
            return k;
        }
        public V getSecond() {
            return v;
        }
        @Override
        public String toString() {
            return "Pair{" +
                    "k=" + k +
                    ", v=" + v +
                    '}';
        }

        public static void main(String[] args) {
            Pair<String, Integer> pair = new Pair<>("hello", 20);
            Pair<Integer, String> swapPair = swapItems(pair);
            Pair<Integer, String> swapPair2 = pair.swapItems();

            System.out.println(pair);
            System.out.println(swapPair);
            System.out.println(swapPair2);
        }
    }
}
