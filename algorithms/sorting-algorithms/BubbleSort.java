public class BubbleSort extends Sort {
    @Override
    public Double[] sort(Double[] numbers) {
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    switchOrder(numbers, i, i + 1);
                    isChanged = true;
                }
            }
        }
        return numbers;
    }

    private static void switchOrder(Double[] numbers, int i, int j) {
        double firstNumber = numbers[i];
        double secondNumber = numbers[j];
        numbers[i] = secondNumber;
        numbers[j] = firstNumber;
    }

    public String getAlgorithmName() {
        return "bubble sort";
    }
}
