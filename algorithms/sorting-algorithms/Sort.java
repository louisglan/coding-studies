import static utils.PrintUtils.printFormattedArray;

public abstract class Sort {
    /**
    Sorts the numbers in the array and returns the time taken as a long value in nanoseconds. Prints the sorted numbers to sout
     */
    public long sortAndPrintResults(Double[] numbers) {
        System.out.printf("%s sorted numbers:\n", getAlgorithmName());
        long startTime = System.nanoTime();
        Double[] sortedNumbers = sort(numbers);
        long endTime = System.nanoTime();
        printFormattedArray(sortedNumbers);
        return endTime - startTime;
    }
    public abstract Double[] sort(Double[] numbers);

    public abstract String getAlgorithmName();
}
