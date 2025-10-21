public class QuickSort extends AbstractQuickSort {

    @Override
    public Double[] sort(Double[] numbers) {
        return sort(numbers, 0, numbers.length - 1);
    }

    @Override
    public String getAlgorithmName() {
        return "quick Sort";
    }
}
