import org.junit.Test;

import static org.junit.Assert.*;

public class QuickFindTest {
    @Test
    public void testUnionReplacesFirst() throws Exception {
        QuickFind qf = new QuickFind(10);
        qf.union(1, 2);

        assertEquals("[0 2 2 3 4 5 6 7 8 9]", qf.toString());
    }

    @Test
    public void testUnionReplacesAll() throws Exception {
        QuickFind qf = new QuickFind(10);
        qf.union(1, 2);
        qf.union(1, 3);

        assertEquals("[0 3 3 3 4 5 6 7 8 9]", qf.toString());
    }

    @Test
    public void testUnionDoesNotReplaceItself() throws Exception {
        QuickFind qf = new QuickFind(10);
        qf.union(1, 1);

        assertEquals("[0 1 2 3 4 5 6 7 8 9]", qf.toString());
    }

    @Test
    public void testConnected() throws Exception {
        QuickFind qf = new QuickFind(10);
        qf.union(1, 2);
        qf.union(2, 3);

        assertTrue(qf.connected(1, 3));
    }
}
