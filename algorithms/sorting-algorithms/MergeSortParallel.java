import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MergeSortParallel extends AbstractMergeSort {

    @Override
    public Double[] sort(Double[] numbers) {
        var parallelMergeSort = new MergeTask(numbers);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        return pool.invoke(parallelMergeSort);
    }

    @Override
    public String getAlgorithmName() {
        return "merge sort parallel";
    }

    private class MergeTask extends RecursiveTask<Double[]> {
        private final Double[] numbers;

        public MergeTask(Double[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public Double[] compute() {
            if (numbers.length <= 1) {
                return numbers;
            }
            int arrayLengthAsyncThreshold = 1000;
            if (numbers.length < arrayLengthAsyncThreshold) {
                return divideAndConquer(numbers);
            }
            int mid = numbers.length / 2;
            var leftList = Arrays.copyOfRange(numbers, 0, mid);
            var rightList = Arrays.copyOfRange(numbers, mid, numbers.length);
            var mergeSortLeft = new MergeTask(leftList);
            var mergeSortRight = new MergeTask(rightList);
            mergeSortLeft.fork();
            var sortedRightList = mergeSortRight.compute();
            var sortedLeftList = mergeSortLeft.join();
            return merge(sortedLeftList, sortedRightList);
        }
    }
}