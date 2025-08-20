public class Searching {
    public static void main(String[] args) {
        Search linearSearch = new LinearSearch();
        Double[] numbers = new Double[]{1.23, 2.745, 10.0, 23.45, 121.96, -130.5, -66.0};
        long linearSearchTimeTaken = linearSearch.searchAndPrintResults(numbers, 10.1);
        System.out.printf("%s took %fs\n", linearSearch.getAlgorithmName(), linearSearchTimeTaken / 1000000000.0);
    }
}
