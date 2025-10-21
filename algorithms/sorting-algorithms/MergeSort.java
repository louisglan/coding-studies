/**
 * Merge sort makes use of the "divide and conquer" paradigm. The array is recursively halved into sublists until there
 * is only one element in each sublist. Then, the halved pairs of sublists are combined back together in order. It is
 * faster because you know each sublist is ordered so you only ever have to compare the first elements of the ordered
 * sublists to decide which will be first in the combined sublist
 */
public class MergeSort extends AbstractMergeSort {
    // TODO: implement parallel processing. In divide and conquer algorithms
    //  "solving problems using some defined base cases can be done within the cache memory" - investigate this.
    //  Can also implement in multiple ways e.g., recursively, iteratively, etc. (see Coda notes)
    @Override
    public Double[] sort(Double[] numbers) {
        return divideAndConquer(numbers);
    }

    @Override
    public String getAlgorithmName() {
        return "merge sort";
    }
}
