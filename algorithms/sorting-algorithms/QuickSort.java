import java.util.ArrayList;

public class QuickSort extends Sort {
    // TODO: find a way to switch between array and arraylist less. Maybe create a helper method that is called recursively instead of sort that uses arraylist

    @Override
    public Double[] sort(Double[] numbers) {
        if (numbers.length == 1 || numbers.length == 0) return numbers;
        Double pivot = numbers[numbers.length - 1];
        var lessThanPivot = new ArrayList<Double>();
        var greaterThanPivot = new ArrayList<Double>();
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] <= pivot) {
                lessThanPivot.add(numbers[i]);
            } else {
                greaterThanPivot.add(numbers[i]);
            }
        }
        var sortedLessThanPivot = sort(lessThanPivot.toArray(new Double[0]));
        var sortedGreaterThanPivot = sort(greaterThanPivot.toArray(new Double[0]));
        return combineArraysAndPivot(sortedLessThanPivot, pivot, sortedGreaterThanPivot);
    }
    private Double[] combineArraysAndPivot(Double[] lessThanPivot, Double pivot, Double[] greaterThanPivot) {
        Double[] combinedArray = new Double[lessThanPivot.length + greaterThanPivot.length + 1];
        for (int i = 0; i < combinedArray.length; i++) {
            if (i < lessThanPivot.length) {
                combinedArray[i] = lessThanPivot[i];
            } else if (i == lessThanPivot.length) {
                combinedArray[i] = pivot;
            } else {
                combinedArray[i] = greaterThanPivot[i - lessThanPivot.length - 1];
            }
        }
        return combinedArray;
    }

    @Override
    public String getAlgorithmName() {
        return "quick Sort";
    }


}
