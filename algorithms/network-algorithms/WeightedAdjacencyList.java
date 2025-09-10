import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
}
