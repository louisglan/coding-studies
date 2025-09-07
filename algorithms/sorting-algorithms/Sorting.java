import java.util.Random;

import static utils.PrintUtils.printFormattedArray;

public class Sorting {
    // TODO: Find O(n) (time and space) of each algorithm and attempt to implement algorithm for more than numbers.
    //  Maybe add tests and some documentation comments describing how the algorithm works and other details
    //  Attempt to implement selection, radix, counter and quick sorts
    //  Make sure each algorithm is stable
    public static void main(String[] args) {
        Random rand = new Random();
        int numberCount = 10;
        Double[] numbers = new Double[numberCount];
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = rand.nextDouble(200) - 100;
        }
        System.out.println("Unsorted numbers:");
        printFormattedArray(numbers);

        Sort[] sortingAlgorithms = {
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new InsertionSortV2(),
                new MergeSort(),
                new QuickSort()};

        for (Sort sortingAlgorithm : sortingAlgorithms) {
            sortingAlgorithm.sortAndPrintResults(numbers.clone());
        }

        for (Sort sortingAlgorithm : sortingAlgorithms) {
            System.out.printf("%s time: %fs\n", sortingAlgorithm.getAlgorithmName(), sortingAlgorithm.getWallClockTime() / 1000000000f);
        }
    }
}
