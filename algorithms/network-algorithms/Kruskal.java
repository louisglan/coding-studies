import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This only worked on undirected graphs
public class Kruskal {
    // This turns a directed graph into an undirected graph. Whether this is appropriate or not will depend on use case. In
    // the future I may want to implement a version of this that works for directed graphs but I'm not convinced such a thing
    // would be useful
    public static WeightedAdjacencyList getMinimumSpanningTree(WeightedAdjacencyList adjacencyList) {
        List<Edge> edges = adjacencyList.getEdges();
        Collections.sort(edges);
        WeightedAdjacencyList minimumSpanningTree = new WeightedAdjacencyList();
        for (Edge edge : edges) {
            if (!edgeCreatesCycle(minimumSpanningTree, edge)) {
                minimumSpanningTree.addDirectedEdge(edge.getNode1(), edge.getNode2(), edge.getWeight());
                minimumSpanningTree.addDirectedEdge(edge.getNode2(), edge.getNode1(), edge.getWeight());
            }
        }
        return minimumSpanningTree;
    }

    private static boolean edgeCreatesCycle(WeightedAdjacencyList adjacencyList, Edge edge) {
        List<String> visitedNodes = new ArrayList<>();
        return searchForCycle(visitedNodes, adjacencyList, edge.getNode1(), edge.getNode2());
    }

    private static boolean searchForCycle(List<String> visitedNodes,
                                          WeightedAdjacencyList adjacencyList,
                                          String currentNode, String endOfCycleNode) {
        if (adjacencyList.get(currentNode) == null) return false;
        visitedNodes.add(currentNode);
        boolean isCycle = false;
        for (var neighbour : adjacencyList.get(currentNode)) {
            if (visitedNodes.contains(neighbour.getKey())) continue;
            if (neighbour.getKey().equals(endOfCycleNode)) return true;
            isCycle = searchForCycle(visitedNodes, adjacencyList, neighbour.getKey(), endOfCycleNode);
            if (isCycle) return isCycle;
        }
        return isCycle;
    }

    public static double getTotalMstWeight(WeightedAdjacencyList adjacencyList) {
        WeightedAdjacencyList mst = getMinimumSpanningTree(adjacencyList);
        return mst.getEdges().stream().map(Edge::getWeight).reduce(0.0, Double::sum);
    }
}
