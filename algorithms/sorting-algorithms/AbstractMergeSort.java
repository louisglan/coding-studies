import java.util.Arrays;

public abstract class AbstractMergeSort implements Sort {

    protected Double[] divideAndConquer(Double[] numbers) {
        if (numbers.length > 1) {
            int mid = numbers.length / 2;
            var leftList = Arrays.copyOfRange(numbers, 0, mid);
            var rightList = Arrays.copyOfRange(numbers, mid, numbers.length);
            var conqueredLeftList = divideAndConquer(leftList);
            var conqueredRightList = divideAndConquer(rightList);
            return merge(conqueredLeftList, conqueredRightList);
        }
        return numbers;
    }
    protected Double[] merge(Double[] left, Double[] right) {
        Double[] sortedSublist = new Double[left.length + right.length];
        int leftPointer = 0, rightPointer = 0;

        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] <= right[rightPointer]) {
                sortedSublist[leftPointer + rightPointer] = left[leftPointer++];
            } else {
                sortedSublist[leftPointer + rightPointer] = right[rightPointer++];
            }
        }

        while (leftPointer < left.length) sortedSublist[leftPointer + rightPointer] = left[leftPointer++];
        while (rightPointer < right.length) sortedSublist[leftPointer + rightPointer] = right[rightPointer++];

        return sortedSublist;
    }
}
