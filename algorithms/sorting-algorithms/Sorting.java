import java.util.Random;

import static utils.PrintUtils.printFormattedArray;

public class Sorting {
    // TODO: Find O(n) (time and space) of each algorithm and attempt to implement algorithm for more than numbers.
    //  Maybe add tests and some documentation comments describing how the algorithm works and other details
    public static void main(String[] args) {
        Random rand = new Random();
        int numberCount = 10;
        Double[] numbers = new Double[numberCount];
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = rand.nextDouble(200) - 100;
        }
        System.out.println("Unsorted numbers:");
        printFormattedArray(numbers);

        Sort bubbleSort = new BubbleSort();
        long bubbleSortTime = bubbleSort.sortAndPrintResults(numbers.clone());

        Sort insertionSort = new InsertionSort();
        long insertionSortTime = insertionSort.sortAndPrintResults(numbers.clone());

        Sort insertionSortV2 = new InsertionSortV2();
        long insertionSortV2Time = insertionSortV2.sortAndPrintResults(numbers.clone());

        Sort mergeSort = new MergeSort();
        long mergeSortTime = mergeSort.sortAndPrintResults(numbers.clone());

        System.out.printf("%s time: %fs\n", bubbleSort.getAlgorithmName(), bubbleSortTime / 1000000000f);
        System.out.printf("%s time: %fs\n", insertionSort.getAlgorithmName(), insertionSortTime / 1000000000f);
        System.out.printf("%s time: %fs\n", insertionSortV2.getAlgorithmName(), insertionSortV2Time / 1000000000f);
        System.out.printf("%s time: %fs\n", mergeSort.getAlgorithmName(), mergeSortTime / 1000000000f);
    }
}
