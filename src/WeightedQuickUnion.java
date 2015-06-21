import java.util.ArrayList;

public class WeightedQuickUnion extends UnionFind {
    private int[] sizes;

    public WeightedQuickUnion(int n) {
        super(n);

        sizes = new int[n];
        for(int i = 0; i != sizes.length; ++i) {
            sizes[i] = 1;
        }
    }

    public WeightedQuickUnion(String storageToSet) {
        String[] splitStorage = storageToSet.split(" ");

        storage = new int[splitStorage.length];
        for(int i = 0; i != storage.length; ++i) {
            storage[i] = Integer.parseInt(splitStorage[i]);
        }
    }

    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);

        if (pRoot == qRoot) {
            return;
        }

        if (sizes[pRoot] < sizes[qRoot]) {
            storage[pRoot] = qRoot;
            sizes[qRoot] += sizes[pRoot];
        } else {
            storage[qRoot] = pRoot;
            sizes[pRoot] += sizes[qRoot];
        }
    }

    public boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public void printAsTree() {
        ArrayList<TreeNode> roots = new ArrayList<>();

        for (int i = 0; i != storage.length; ++i) {
            int current = storage[i];
            if (current == i) {
                roots.add(new TreeNode(String.valueOf(i), children(current)));
            }
        }

        new TreeNode("virtual head", roots).print();

    }

    private ArrayList<TreeNode> children(int parent) {
        ArrayList<TreeNode> children = new ArrayList<>();

        for (int current = 0; current != storage.length; ++current) {
            int parentOfCurrent = storage[current];

            if (parentOfCurrent == parent && current != parentOfCurrent) {
                children.add(new TreeNode(String.valueOf(current), children(current)));
            }
        }

        return children;
    }

    private int getRoot(int element) {
        while (element != storage[element]) {
            element = storage[element];
        }

        return element;
    }
}
