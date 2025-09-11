public class Edge implements Comparable<Edge> {
    private final String node1;
    private final String node2;
    private final Double weight;

    Edge(String node1, String node2, Double weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public String getNode1() {
        return node1;
    }

    public String getNode2() {
        return node2;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.getWeight().compareTo(edge.getWeight());
    }
}
