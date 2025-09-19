import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacencyList extends HashMap<String, List<String>> {
    public void addEdge(String node1, String node2) {
        addDirectedEdge(node1, node2);
        addDirectedEdge(node2, node1);
    }

    private void addDirectedEdge(String node1, String node2) {
        if (this.get(node1) == null) {
            this.put(node1, new ArrayList<>(List.of(node2)));
        } else {
            this.get(node1).add(node2);
        }
    }
}
