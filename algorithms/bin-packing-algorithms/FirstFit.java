import java.util.ArrayList;
import java.util.List;

public class FirstFit extends BinPack {
    public List<Bin> pack(List<Double> numbers, Double binCapacity) {
        List<Bin> bins = new ArrayList<>();
        bins.add(new Bin(binCapacity));
        for (Double number : numbers) {
            addNumber(bins, number, binCapacity);
        }
        return bins;
    }

    private static void addNumber(List<Bin> bins, Double number, Double binCapacity) {
        for (Bin bin : bins) {
            if (bin.hasCapacityFor(number)) {
                bin.add(number);
                return;
            }
        }
        Bin newBin = new Bin(binCapacity);
        newBin.add(number);
        bins.add(newBin);
    }

    @Override
    public String getAlgorithmName() {
        return "first fit";
    }
}
