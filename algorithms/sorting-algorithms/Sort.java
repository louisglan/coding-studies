import utils.Timer;

import static utils.PrintUtils.printFormattedArray;

public interface Sort {
    /**
    Sorts the numbers in the array and saves the most recent time taken as a long value in nanoseconds. Prints the sorted numbers to sout
     */
    default long sortAndPrintResults(Double[] numbers) {
        System.out.printf("%s sorted numbers:\n", getAlgorithmName());
        Timer timer = new Timer();
        timer.start();
        Double[] sortedNumbers = sort(numbers);
        long wallClockTime = timer.stop();
        printFormattedArray(sortedNumbers);
        return wallClockTime;
    }
    Double[] sort(Double[] numbers);

    String getAlgorithmName();
}
