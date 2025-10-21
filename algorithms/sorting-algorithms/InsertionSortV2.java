/**
 * In this simpler implementation of insertion sort, the list is not split into two. Instead, the insertion works by
 * moving all the elements before the inspected element that are larger than it up and then filling the empty space with
 * the inspected element
 */
public class InsertionSortV2 implements Sort {
    @Override
    public Double[] sort(Double[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            Double currentNumber = numbers[i];
            int j = i - 1;
            while (j >= 0 && currentNumber < numbers[j]) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = currentNumber;
        }
        return numbers;
    }

    public String getAlgorithmName() {
        return "insertion sort v2";
    }
}
