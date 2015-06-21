public class Main {

    public static void main(String[] args) {
        System.out.println(new QuickFind(10).unionAll("4-8 0-8 2-9 5-9 3-7 8-7").toString());
        System.out.println(new WeightedQuickUnion(10).unionAll("9-8 3-4 6-8 0-1 2-7 2-1 3-9 6-5 5-1").toString());


        String[] weightedStorages = {
                "8 4 8 8 3 3 1 7 8 8",
                "8 4 8 8 3 3 1 7 8 8",
                "5 5 3 4 1 3 3 3 3 3",
                "8 1 2 3 8 2 6 7 8 9",
                "6 2 6 4 5 5 5 6 6 7",
                "7 7 3 0 7 9 9 7 0 7"
        };

        for (String storage : weightedStorages) {
            new WeightedQuickUnion(storage).printAsTree();
        }
    }
}
