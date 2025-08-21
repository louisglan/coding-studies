import static utils.PrintUtils.printFormattedArray;

public abstract class Sort {
    private long timeTaken;
    /**
    Sorts the numbers in the array and saves the most recent time taken as a long value in nanoseconds. Prints the sorted numbers to sout
     */
    public void sortAndPrintResults(Double[] numbers) {
        System.out.printf("%s sorted numbers:\n", getAlgorithmName());
        long startTime = System.nanoTime();
        Double[] sortedNumbers = sort(numbers);
        long endTime = System.nanoTime();
        printFormattedArray(sortedNumbers);
        timeTaken = endTime - startTime;
    }
    public abstract Double[] sort(Double[] numbers);

    public abstract String getAlgorithmName();

    public long getTimeTaken() {
        return timeTaken;
    }
}
