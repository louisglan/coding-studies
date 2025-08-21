public class SelectionSort extends Sort{
    @Override
    public Double[] sort(Double[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[currentMinIndex]) {
                    currentMinIndex = j;
                }
            }
            Double minUnsortedValue = numbers[currentMinIndex];
            numbers[currentMinIndex] = numbers[i];
            numbers[i] = minUnsortedValue;
        }
        return numbers;
    }

    @Override
    public String getAlgorithmName() {
        return "selection sort";
    }
}
