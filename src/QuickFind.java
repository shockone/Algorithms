public class QuickFind extends UnionFind {
    public QuickFind(int n) {
        super(n);
    }

    public void union(int p, int q) {
        int pGroup = storage[p];
        int qGroup = storage[q];

        for (int i = 0; i != storage.length; ++i) {
            if (storage[i] == pGroup) {
                storage[i] = qGroup;
            }
        }
    }

    public boolean connected(int p, int q) {
        return storage[p] == storage[q];
    }
}
