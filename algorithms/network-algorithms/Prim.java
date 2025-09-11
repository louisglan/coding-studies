import java.util.ArrayList;
import java.util.Random;

public class Prim {
    public static WeightedAdjacencyList getMinimumSpanningTree(WeightedAdjacencyList adjacencyList) {
        WeightedAdjacencyList mst = new WeightedAdjacencyList();
        String startingNode = getRandomStartingNode(adjacencyList);
        Double minWeight = Double.MAX_VALUE;
        Edge newEdge = new Edge(startingNode, "", minWeight);
        for (var neighbour : adjacencyList.get(startingNode)) {
            if (neighbour.getValue() < minWeight) {
                newEdge = new Edge(startingNode, neighbour.getKey(), neighbour.getValue());
                minWeight = neighbour.getValue();
            }
        }
        mst.addUndirectedEdge(newEdge);
        while (mst.size() < adjacencyList.size()) {
            addLightestConnectedEdge(mst, adjacencyList);
        }
        return mst;
    }

    public static Double getTotalMstWeight(WeightedAdjacencyList adjacencyList) {
        WeightedAdjacencyList mst = getMinimumSpanningTree(adjacencyList);
        return mst.getEdges().stream().map(Edge::getWeight).reduce(0.0, Double::sum);
    }

    private static String getRandomStartingNode(WeightedAdjacencyList adjacencyList) {
        ArrayList<String> keysAsArray = new ArrayList<>(adjacencyList.keySet());
        Random r = new Random();
        return keysAsArray.get(r.nextInt(keysAsArray.size()));
    }

    private static void addLightestConnectedEdge(WeightedAdjacencyList mst, WeightedAdjacencyList adjacencyList) {
        Double minWeight = Double.MAX_VALUE;
        Edge newEdge = new Edge("", "", minWeight);
        for (String mstNode : mst.keySet()) {
            for (var neighbour : adjacencyList.get(mstNode)) {
                if (!mst.containsKey(neighbour.getKey()) && neighbour.getValue() < minWeight) {
                    newEdge = new Edge(mstNode, neighbour.getKey(), neighbour.getValue());
                    minWeight = neighbour.getValue();
                }
            }
        }
        mst.addUndirectedEdge(newEdge);
    }
}
