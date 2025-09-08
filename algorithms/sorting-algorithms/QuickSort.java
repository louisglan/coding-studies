public class QuickSort extends Sort {

    @Override
    public Double[] sort(Double[] numbers) {
        return sort(numbers, 0, numbers.length - 1);
    }

    private Double[] sort(Double[] numbers, int startIndex, int endIndex) {
        if (Math.abs(startIndex - endIndex) <= 1) return numbers;
        int finalPivotIndex = partition(numbers, startIndex, endIndex);
        sort(numbers, startIndex, finalPivotIndex - 1);
        sort(numbers, finalPivotIndex + 1, endIndex);
        return numbers;
    }

    private int partition(Double[] numbers, int startIndex, int endIndex) {
        int pivotIndex = medianOfThree(numbers, startIndex, endIndex);
        swap(numbers, pivotIndex, endIndex);
        Double pivot = numbers[endIndex];
        int i = startIndex;
        for (int j = startIndex; j < endIndex; j++) {
            if (numbers[j] < pivot) {
                swap(numbers, i, j);
                i++;
            }
        }
        swap(numbers, i, endIndex);
        return i;
    }

    private int medianOfThree(Double[] numbers, int startIndex, int endIndex) {
        int medianIndex = (startIndex + endIndex)/2;
        if (numbers[startIndex] < numbers[endIndex] ^ numbers[startIndex] < numbers[medianIndex]) {
            return startIndex;
        }
        if (numbers[endIndex] > numbers[startIndex] ^ numbers[endIndex] > numbers[medianIndex]) {
            return endIndex;
        }
        return medianIndex;
    }

    private void swap(Double[] numbers, int i, int j) {
        Double temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    @Override
    public String getAlgorithmName() {
        return "quick Sort";
    }
}
