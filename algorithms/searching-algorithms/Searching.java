public class Searching {
    public static void main(String[] args) {
        Double[] numbers = new Double[]{1.0, 2.7, 3.9, 5.12, 20.6, 102.3};
        Double numberToFind = 102.3;

        Search linearSearch = new LinearSearch();
        long linearSearchTimeTaken = linearSearch.searchAndPrintResults(numbers, numberToFind);

        Search binarySearch = new BinarySearch();
        long BinarySearchTimeTaken = binarySearch.searchAndPrintResults(numbers, numberToFind);

        System.out.printf("%s took %fs\n", linearSearch.getAlgorithmName(), linearSearchTimeTaken / 1000000000.0);
        System.out.printf("%s took %fs\n", binarySearch.getAlgorithmName(), BinarySearchTimeTaken / 1000000000.0);
    }
}
