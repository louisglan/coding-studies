/**
 * Selection sort works by inspecting each element in the list and for each element, looping through the rest of the
 * array after that element. The smallest element is swapped with the selected element
*/
public class SelectionSort implements Sort{
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
