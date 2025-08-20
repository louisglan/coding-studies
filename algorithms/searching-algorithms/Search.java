public abstract class Search {
    /**
     Searches for the number in the array and returns the time taken as a long value in nanoseconds. Prints 'Found' or 'Not found' depending on result
     */
    public long searchAndPrintResults(Double[] numbers, Double numberToFind) {
        System.out.printf("%s:\n", this.getAlgorithmName());
        long startTime = System.nanoTime();
        boolean isFound = search(numbers, numberToFind);
        System.out.println(isFound ? "Found" : "Not found");
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public abstract boolean search(Double[] numbers, Double numberToFind);
    public abstract String getAlgorithmName();
}
