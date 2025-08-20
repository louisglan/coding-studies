import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BinarySearch extends Search {
    /**
    This algorithm assumes the list is sorted
     */
    @Override
    public boolean search(Double[] numbers, Double numberToFind) {
        ArrayList<Double> numbersAsList = new ArrayList<>(Arrays.asList(numbers));
        return checkHalfWayPoint(numbersAsList, numberToFind);
    }

    private boolean checkHalfWayPoint(ArrayList<Double> numbersAsList, Double numberToFind) {
        int halfWayIndex = numbersAsList.size() / 2;
        Double inspectedNumber = numbersAsList.get(halfWayIndex);
        if (Objects.equals(numberToFind, inspectedNumber)) return true;
        if (numbersAsList.size() == 1) return false;
        ArrayList<Double> reducedList = discardHalfOfList(numbersAsList, numberToFind, inspectedNumber);
        return checkHalfWayPoint(reducedList, numberToFind);
    }

    private ArrayList<Double> discardHalfOfList(ArrayList<Double> numbers, Double numberToFind, Double inspectedNumber) {
        int subListStartIndex;
        int subListEndIndex;
        if (numberToFind < inspectedNumber) {
            subListStartIndex = 0;
            subListEndIndex = numbers.size() / 2;
        } else {
            subListStartIndex = numbers.size() / 2;
            subListEndIndex = numbers.size();
        }
        return new ArrayList<>(numbers.subList(subListStartIndex, subListEndIndex));
    }

    @Override
    public String getAlgorithmName() {
        return "binary search";
    }
}
