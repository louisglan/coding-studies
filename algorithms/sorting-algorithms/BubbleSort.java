public class BubbleSort {
    public static int[] sort(int[] numbers) {
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

    private static void switchOrder(int[] numbers, int i, int j) {
        int firstNumber = numbers[i];
        int secondNumber = numbers[j];
        numbers[i] = secondNumber;
        numbers[j] = firstNumber;
    }
}
