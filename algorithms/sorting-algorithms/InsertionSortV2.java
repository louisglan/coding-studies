import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InsertionSortV2 extends Sort {
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
