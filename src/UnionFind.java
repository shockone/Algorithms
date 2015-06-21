import java.util.Arrays;

/**
 * Created by me on 6/21/15.
 */
abstract public class UnionFind {
    protected int[] storage;

    public UnionFind() { }

    public UnionFind(int n) {
        storage = new int[n];

        for (int i = 0; i != n; ++i) {
            storage[i] = i;
        }
    }

    abstract public void union(int p, int q);
    abstract public boolean connected(int p, int q);

    public UnionFind unionAll(String pairs) {
        Arrays.stream(pairs.split(" "))
                .map(e -> Arrays.stream(e.split("-")).map(Integer::valueOf).toArray(Integer[]::new))
                .forEach(pair -> this.union(pair[0], pair[1]));

        return this;
    }

    @Override
    public String toString() {
        return Arrays.toString(storage).replaceAll(",", "");
    }
}
