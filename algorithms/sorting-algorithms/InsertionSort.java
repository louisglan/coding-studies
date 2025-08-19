import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InsertionSort extends Sort {
    @Override
    public Double[] sort(Double[] numbers) {
        ArrayList<Double> numbersAsList = new ArrayList<>(Arrays.asList(numbers));
        ArrayList<Double> sortedList = new ArrayList<>(Collections.singletonList(numbersAsList.get(0)));
        ArrayList<Double> unsortedList = new ArrayList<>(numbersAsList.subList(1,numbersAsList.size()));
        for (Double el : unsortedList) {
            insertIntoSortedList(el, sortedList);
        }
        return sortedList.toArray(new Double[0]);
    }

    private static void insertIntoSortedList(Double elementToInsert, ArrayList<Double> sortedList) {
        if (isBeforeFirstElement(elementToInsert, sortedList)) {
            sortedList.add(0, elementToInsert);
            return;
        } else if (isAfterLastElement(elementToInsert, sortedList)) {
            sortedList.add(elementToInsert);
            return;
        }
        for (int i = 0; i < sortedList.size() - 1; i++) {
            if (elementToInsert >= sortedList.get(i) && elementToInsert < sortedList.get(i + 1)) {
                sortedList.add(i + 1, elementToInsert);
                return;
            }
        }
    }

    private static boolean isBeforeFirstElement(Double element, ArrayList<Double> sortedList) {
        return element <= sortedList.get(0);
    }

    private static boolean isAfterLastElement(Double element, ArrayList<Double> sortedList) {
        return element > sortedList.get(sortedList.size() - 1);
    }

    public String getAlgorithmName() {
        return "insertion sort";
    }
}
