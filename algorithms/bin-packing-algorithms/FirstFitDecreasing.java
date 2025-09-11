import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstFitDecreasing extends BinPack {
    public List<Bin> pack(List<Double> numbers, Double binCapacity) {
        ArrayList<Double> numbersToSort = new ArrayList<>(numbers);
        Collections.sort(numbersToSort);
        return new FirstFit().pack(numbersToSort.reversed(), binCapacity);
    }

    @Override
    public String getAlgorithmName() {
        return "first fit decreasing";
    }
}
