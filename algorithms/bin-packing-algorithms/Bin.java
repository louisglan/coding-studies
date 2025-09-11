public class Bin {
    private Double remainingCapacity;

    public Bin(Double capacity) {
        this.remainingCapacity = capacity;
    }

    public boolean hasCapacityFor(Double number) {
        return remainingCapacity - number >= 0;
    }

    public void add(Double number) {
        if (!hasCapacityFor(number)) return;
        remainingCapacity -= number;
    }

    public Double getRemainingCapacity() {
        return remainingCapacity;
    }
}
