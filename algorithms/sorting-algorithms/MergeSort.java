import java.util.ArrayList;
import java.util.Arrays;

/**
 * Merge sort makes use of the "divide and conquer" paradigm. The array is recursively halved into sublists until there
 * is only one element in each sublist. Then, the halved pairs of sublists are combined back together in order. It is
 * faster because you know each sublist is ordered so you only ever have to compare the first elements of the ordered
 * sublists to decide which will be first in the combined sublist
 */
public class MergeSort extends Sort {
    // TODO: implement parallel processing. In divide and conquer algorithms
    //  "solving problems using some defined base cases can be done within the cache memory" - investigate this.
    //  Can also implement in multiple ways e.g., recursively, iteratively, etc. (see Coda notes)
    @Override
    public Double[] sort(Double[] numbers) {
        ArrayList<Double> numbersAsList = new ArrayList<>(Arrays.asList(numbers));
        return divideAndConquer(numbersAsList).toArray(new Double[0]);
    }

    private ArrayList<Double> divideAndConquer(ArrayList<Double> numbers) {
        if (numbers.size() > 1) {
            var leftList = new ArrayList<>(numbers.subList(0, numbers.size() / 2));
            var rightList = new ArrayList<>(numbers.subList(numbers.size() / 2, numbers.size()));
            var conqueredLeftList = divideAndConquer(leftList);
            var conqueredRightList = divideAndConquer(rightList);
            var sortedSubList = new ArrayList<Double>();
            while (!conqueredLeftList.isEmpty() || !conqueredRightList.isEmpty()) {
                moveSmallestElementToSubList(conqueredLeftList, conqueredRightList, sortedSubList);
            }
            return sortedSubList;
        }
        return numbers;
    }

    private void moveSmallestElementToSubList(
            ArrayList<Double> conqueredLeftList,
            ArrayList<Double> conqueredRightList,
            ArrayList<Double> subList) {
        if (conqueredLeftList.isEmpty()) {
            subList.add(conqueredRightList.removeFirst());
        } else if (conqueredRightList.isEmpty()) {
            subList.add(conqueredLeftList.removeFirst());
        } else if (conqueredLeftList.getFirst() <= conqueredRightList.getFirst()) {
            subList.add(conqueredLeftList.removeFirst());
        } else {
            subList.add(conqueredRightList.removeFirst());
        }
    }

    @Override
    public String getAlgorithmName() {
        return "merge sort";
    }
}
