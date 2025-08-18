import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class Sorting {
    // TODO: Find O(n) (time and space) of each algorithm and attempt to implement algorithm for more than numbers. Maybe add tests
    public static void main(String[] args) {
        Random rand = new Random();
        int numberCount = 10000;
        Double[] numbers = new Double[numberCount];
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = rand.nextDouble(200) - 100;
        }
        System.out.println("Unsorted numbers:");
        printFormattedArray(numbers);

        Sort bubbleSort = new BubbleSort();
        long bubbleSortTime = sort(numbers, bubbleSort);

        Sort insertionSort = new InsertionSort();
        long insertionSortTime = sort(numbers, insertionSort);
        System.out.printf("%s time: %fs\n", bubbleSort.getAlgorithmName(), bubbleSortTime / 1000000000f);
        System.out.printf("%s time: %fs\n", insertionSort.getAlgorithmName(), insertionSortTime / 1000000000f);
    }

    public static void printFormattedArray(Double[] numbers) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        for (Double number : numbers) {
            System.out.println(df.format(number));
        }
    }

    private static long sort(Double[] numbers, Sort sortingAlgorithm) {
        System.out.printf("%s sorted numbers:\n", sortingAlgorithm.getAlgorithmName());
        long startTime = System.nanoTime();
        Double[] sortedNumbers = sortingAlgorithm.sort(numbers);
        long endTime = System.nanoTime();
        printFormattedArray(sortedNumbers);
        return endTime - startTime;
    }
}
