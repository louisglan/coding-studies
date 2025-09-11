import java.util.*;

public class WeightedAdjacencyList extends HashMap<String, List<AbstractMap.SimpleEntry<String, Double>>> {
    public void addDirectedEdge(String startNode, String endNode, Double weight) {
        if (this.get(startNode) == null) {
            ArrayList<SimpleEntry<String, Double>> adjacentEdges = new ArrayList<>();
            adjacentEdges.add(new SimpleEntry<>(endNode, weight));
            this.put(startNode, adjacentEdges);
            return;
        }
        this.get(startNode).add(new AbstractMap.SimpleEntry<>(endNode, weight));
    }

    public void addUndirectedEdge(Edge edge) {
        this.addDirectedEdge(edge.getNode1(), edge.getNode2(), edge.getWeight());
        this.addDirectedEdge(edge.getNode2(), edge.getNode1(), edge.getWeight());
    }

    public List<Edge> getEdges() {
        AdjacencyList edgesAdded = new AdjacencyList();
        List<Edge> edges = new ArrayList<>();
        for (String node : this.keySet()) {
            for (var neighbour : this.get(node)) {
                if (edgesAdded.get(neighbour.getKey()) == null || !edgesAdded.get(neighbour.getKey()).contains(node)) {
                    edges.add(new Edge(node, neighbour.getKey(), neighbour.getValue()));
                    if (edgesAdded.get(node) == null) {
                        edgesAdded.put(node, new ArrayList<>(Collections.singletonList(neighbour.getKey())));
                    } else {
                        edgesAdded.get(node).add(neighbour.getKey());
                    }
                }
            }
        }
        return edges;
    }
}
