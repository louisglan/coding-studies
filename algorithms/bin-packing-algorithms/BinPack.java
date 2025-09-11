import java.util.List;

public abstract class BinPack {
    public abstract List<Bin> pack(List<Double> numbers, Double binCapacity);

    public Double getWastedSpace(List<Double> numbers, Double binCapacity) {
        List<Bin> bins = this.pack(numbers, binCapacity);
        return bins.stream().map(Bin::getRemainingCapacity).reduce(0.0, Double::sum);
    }

    public abstract String getAlgorithmName();
}


