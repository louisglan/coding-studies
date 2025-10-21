import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class QuickSortParallel extends AbstractQuickSort {

    @Override
    public Double[] sort(Double[] numbers) {
        PartitionTask partitionTask = new PartitionTask(numbers, 0, numbers.length - 1);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        return pool.invoke(partitionTask);
    }

    @Override
    public String getAlgorithmName() {
        return "quick sort parallel";
    }

    private class PartitionTask extends RecursiveTask<Double[]> {
        private final Double[] numbers;
        private final int startIndex;
        private final int endIndex;
        public PartitionTask (Double[] numbers, int startIndex, int endIndex) {
            this.numbers = numbers;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        protected Double[] compute() {
            if (startIndex == endIndex) return numbers;
            int finalPivotIndex = partition(numbers, startIndex, endIndex);
            if (startIndex + 1 == endIndex) return numbers;
            int arrayLengthAsyncThreshold = 10_000;
            if (endIndex - startIndex < arrayLengthAsyncThreshold) {
                return sort(numbers, startIndex, endIndex);
            }
            var partitionTaskLeft = new PartitionTask(numbers, startIndex, finalPivotIndex - 1);
            partitionTaskLeft.fork();
            var partitionTaskRight = new PartitionTask(numbers, finalPivotIndex + 1, endIndex);
            partitionTaskRight.compute();
            partitionTaskLeft.join();
            return numbers;
        }
    }
}
