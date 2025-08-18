import static utils.PrintUtils.printFormattedArray;

public abstract class Sort {
    public long sortAndPrint(Double[] numbers) {
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
