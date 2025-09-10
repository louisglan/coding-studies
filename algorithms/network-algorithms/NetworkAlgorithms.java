import java.util.ArrayList;

// TODO: implement DFS and BFS on adjacency matrices
public class NetworkAlgorithms {
    public static void main(String[] args) {
        processUnweightedGraphs();
        processWeightedGraphs();
    }

    private static void processUnweightedGraphs() {
        AdjacencyList adjacencyList = new AdjacencyList();
        // Graph from 3D.5 in Edexcel A level D1
        adjacencyList.put("A", new String[]{"B", "C", "D"});
        adjacencyList.put("B", new String[]{"A", "C", "E"});
        adjacencyList.put("C", new String[]{"A", "B", "D", "E", "F"});
        adjacencyList.put("D", new String[]{"A", "C", "F", "G"});
        adjacencyList.put("E", new String[]{"B", "C", "F", "H"});
        adjacencyList.put("F", new String[]{"C", "D", "E", "G", "H"});
        adjacencyList.put("G", new String[]{"D", "F", "H"});
        adjacencyList.put("H", new String[]{"E", "F", "G"});

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
        WeightedAdjacencyList adjacencyList = new WeightedAdjacencyList();
        adjacencyList.addDirectedEdge("A", "B", 5.0);
        adjacencyList.addDirectedEdge("A", "C", 2.0);
        adjacencyList.addDirectedEdge("B", "C", 2.0);
        adjacencyList.addDirectedEdge("B", "D", 4.0);
        adjacencyList.addDirectedEdge("B", "A", 5.0);
        adjacencyList.addDirectedEdge("C", "B", 2.0);
        adjacencyList.addDirectedEdge("C", "D", 3.0);
        adjacencyList.addDirectedEdge("C", "E", 5.0);
        adjacencyList.addDirectedEdge("D", "B", 4.0);
        adjacencyList.addDirectedEdge("D", "C", 3.0);
        adjacencyList.addDirectedEdge("D", "E", 1.0);
        adjacencyList.addDirectedEdge("D", "F", 9.0);
        adjacencyList.addDirectedEdge("D", "G", 11.0);
        adjacencyList.addDirectedEdge("E", "A", 5.0);
        adjacencyList.addDirectedEdge("E", "F", 8.0);
        adjacencyList.addDirectedEdge("E", "I", 14.0);
        adjacencyList.addDirectedEdge("F", "E", 8.0);
        adjacencyList.addDirectedEdge("F", "D", 9.0);
        adjacencyList.addDirectedEdge("F", "G", 1.0);
        adjacencyList.addDirectedEdge("F", "H", 5.0);
        adjacencyList.addDirectedEdge("F", "I", 7.0);
        adjacencyList.addDirectedEdge("G", "D", 11.0);
        adjacencyList.addDirectedEdge("G", "H", 2.0);
        adjacencyList.addDirectedEdge("H", "F", 5.0);
        adjacencyList.addDirectedEdge("H", "I", 2.0);
        adjacencyList.addDirectedEdge("I", "E", 14.0);
        adjacencyList.addDirectedEdge("I", "F", 7.0);
        adjacencyList.addDirectedEdge("I", "H", 2.0);

        String startNode = "A";
        String endNode = "H";

        System.out.println("Dijkstra:");
        ArrayList<String> dijkstraPath = Dijkstra.findShortestRoute(adjacencyList, startNode, endNode);
        for (String node : dijkstraPath) {
            System.out.println(node);
        }

        System.out.println("Dijkstra distance: " + Dijkstra.getShortestDistance(adjacencyList, startNode, endNode));
    }
}
