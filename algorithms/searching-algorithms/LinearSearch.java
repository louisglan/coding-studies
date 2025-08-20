import java.util.Objects;

public class LinearSearch extends Search {
    @Override
    public boolean search(Double[] numbers, Double numberToFind) {
        for (Double number : numbers) {
            if (Objects.equals(number, numberToFind)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getAlgorithmName() {
        return "linear search";
    }
}
