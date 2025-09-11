import java.util.ArrayList;
import java.util.List;

// TODO: implement DFS and BFS on adjacency matrices
public class NetworkAlgorithms {
    public static void main(String[] args) {
        processUnweightedGraphs();
        processWeightedGraphs();
    }

    private static void processUnweightedGraphs() {
        AdjacencyList adjacencyList = new AdjacencyList();
        // Graph from 3D.5 in Edexcel A level D1
        adjacencyList.put("A", List.of("B", "C", "D"));
        adjacencyList.put("B", List.of("A", "C", "E"));
        adjacencyList.put("C", List.of("A", "B", "D", "E", "F"));
        adjacencyList.put("E", List.of("B", "C", "F", "H"));
        adjacencyList.put("D", List.of("A", "C", "F", "G"));
        adjacencyList.put("F", List.of("C", "D", "E", "G", "H"));
        adjacencyList.put("G", List.of("D", "F", "H"));
        adjacencyList.put("H", List.of("E", "F", "G"));

        String startNode = "H";
        String endNode = "A";

        System.out.println("DFS recursive:");
        ArrayList<String> dfsRecursivePath = DfsRecursive.findRoute(adjacencyList, startNode, endNode);
        for (String node : dfsRecursivePath) {
            System.out.println(node);
        }

        System.out.println("DFS iterative:");
        ArrayList<String> dfsIterativePath = DfsIterative.findRoute(adjacencyList, startNode, endNode);
        for (String node : dfsIterativePath) {
            System.out.println(node);
        }

        System.out.println("BFS iterative:");
        ArrayList<String> bfsIterativePath = BfsIterative.findShortestRoute(adjacencyList, startNode, endNode);
        for (String node : bfsIterativePath) {
            System.out.println(node);
        }
        System.out.println("BFS distance: " + BfsIterative.findShortestDistance(adjacencyList, startNode, endNode));
    }

    private static void processWeightedGraphs() {
        // Graph from 3.4 example 7 in Edexcel A level D1
        WeightedAdjacencyList directedAdjacencyList = new WeightedAdjacencyList();
        directedAdjacencyList.addDirectedEdge("A", "B", 5.0);
        directedAdjacencyList.addDirectedEdge("A", "C", 2.0);
        directedAdjacencyList.addDirectedEdge("B", "C", 2.0);
        directedAdjacencyList.addDirectedEdge("B", "D", 4.0);
        directedAdjacencyList.addDirectedEdge("B", "A", 5.0);
        directedAdjacencyList.addDirectedEdge("C", "B", 2.0);
        directedAdjacencyList.addDirectedEdge("C", "D", 3.0);
        directedAdjacencyList.addDirectedEdge("C", "E", 5.0);
        directedAdjacencyList.addDirectedEdge("D", "B", 4.0);
        directedAdjacencyList.addDirectedEdge("D", "C", 3.0);
        directedAdjacencyList.addDirectedEdge("D", "E", 1.0);
        directedAdjacencyList.addDirectedEdge("D", "F", 9.0);
        directedAdjacencyList.addDirectedEdge("D", "G", 11.0);
        directedAdjacencyList.addDirectedEdge("E", "A", 5.0);
        directedAdjacencyList.addDirectedEdge("E", "F", 8.0);
        directedAdjacencyList.addDirectedEdge("E", "I", 14.0);
        directedAdjacencyList.addDirectedEdge("F", "E", 8.0);
        directedAdjacencyList.addDirectedEdge("F", "D", 9.0);
        directedAdjacencyList.addDirectedEdge("F", "G", 1.0);
        directedAdjacencyList.addDirectedEdge("F", "H", 5.0);
        directedAdjacencyList.addDirectedEdge("F", "I", 7.0);
        directedAdjacencyList.addDirectedEdge("G", "D", 11.0);
        directedAdjacencyList.addDirectedEdge("G", "H", 2.0);
        directedAdjacencyList.addDirectedEdge("H", "F", 5.0);
        directedAdjacencyList.addDirectedEdge("H", "I", 2.0);
        directedAdjacencyList.addDirectedEdge("I", "E", 14.0);
        directedAdjacencyList.addDirectedEdge("I", "F", 7.0);
        directedAdjacencyList.addDirectedEdge("I", "H", 2.0);


        String startNode = "A";
        String endNode = "H";

        System.out.println("Dijkstra:");
        ArrayList<String> dijkstraPath = Dijkstra.findShortestRoute(directedAdjacencyList, startNode, endNode);
        for (String node : dijkstraPath) {
            System.out.println(node);
        }
        System.out.println("Dijkstra distance: " + Dijkstra.getShortestDistance(directedAdjacencyList, startNode, endNode));

        System.out.println("Kruskal:");
        WeightedAdjacencyList kruskalMst = Kruskal.getMinimumSpanningTree(directedAdjacencyList);
        for (Edge edge: kruskalMst.getEdges()) {
            System.out.println(edge.getNode1() + edge.getNode2() + ": " + edge.getWeight());
        }
        System.out.println("Kruskal total weight: " + Kruskal.getTotalMstWeight(directedAdjacencyList));
    }
}
