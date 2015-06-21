import org.junit.Test;

import static org.junit.Assert.*;

public class WeightedQuickUnionTest {

    @Test
    public void testUnionEqualSize() throws Exception {
        UnionFind qf = new WeightedQuickUnion(10);
        qf.union(2, 3);

        assertEquals("[0 1 2 2 4 5 6 7 8 9]", qf.toString());
    }

    @Test
    public void testUnionMultiple() throws Exception {
        UnionFind qf = new WeightedQuickUnion(10);
        qf.union(2, 3);
        qf.union(1, 2);
        qf.union(4, 5);
        qf.union(4, 2);

        assertEquals("[0 2 2 2 2 4 6 7 8 9]", qf.toString());
    }

    @Test
    public void testUnionDifferentHeight() throws Exception {
        UnionFind qf = new WeightedQuickUnion(10);
        qf.unionAll("9-8 3-4 6-8");

        assertEquals("[0 1 2 3 3 5 9 7 9 9]", qf.toString());
    }

    @Test
    public void testConnected() throws Exception {

    }
}
