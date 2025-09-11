import java.util.List;

public class BinPacking {
    public static void main(String[] args) {
        List<Double> numbers = List.of(8.0, 7.0, 14.0, 9.0, 6.0, 9.0, 5.0, 15.0, 6.0, 7.0, 8.0);
        Double binCapacity = 20.0;

        List<BinPack> packingAlgorithms = List.of(new FirstFit(), new FirstFitDecreasing());
        for (BinPack algorithm : packingAlgorithms) {
            System.out.println(algorithm.getAlgorithmName());
            for (Bin bin : algorithm.pack(numbers, binCapacity))
                System.out.println(bin.getRemainingCapacity());
            System.out.println(algorithm.getAlgorithmName() + " wasted space: " + algorithm.getWastedSpace(numbers, binCapacity));
        }
    }
}
