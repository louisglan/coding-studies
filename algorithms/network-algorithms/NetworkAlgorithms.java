import java.util.ArrayList;
import java.util.List;

// TODO: implement DFS and BFS on adjacency matrices
public class NetworkAlgorithms {
    public static void main(String[] args) {
        processUnweightedGraphs();
        processWeightedGraphs();
    }

    private static void processUnweightedGraphs() {
        AdjacencyList graph = new AdjacencyList();
        // Graph from 3D.5 in Edexcel A level D1
        graph.put("A", List.of("B", "C", "D"));
        graph.put("B", List.of("A", "C", "E"));
        graph.put("C", List.of("A", "B", "D", "E", "F"));
        graph.put("E", List.of("B", "C", "F", "H"));
        graph.put("D", List.of("A", "C", "F", "G"));
        graph.put("F", List.of("C", "D", "E", "G", "H"));
        graph.put("G", List.of("D", "F", "H"));
        graph.put("H", List.of("E", "F", "G"));
        AdjacencyList bipartiteGraphGroup1 = getBipartiteGroup1AdjacencyList();
        AdjacencyList bipartiteGraphGroup2 = getBipartiteGroup2AdjacencyList();

        String startNode = "H";
        String endNode = "A";

        System.out.println("DFS recursive:");
        ArrayList<String> dfsRecursivePath = DfsRecursive.findRoute(graph, startNode, endNode);
        for (String node : dfsRecursivePath) {
            System.out.println(node);
        }

        System.out.println("DFS iterative:");
        ArrayList<String> dfsIterativePath = DfsIterative.findRoute(graph, startNode, endNode);
        for (String node : dfsIterativePath) {
            System.out.println(node);
        }

        System.out.println("BFS iterative:");
        ArrayList<String> bfsIterativePath = BfsIterative.findShortestRoute(graph, startNode, endNode);
        for (String node : bfsIterativePath) {
            System.out.println(node);
        }
        System.out.println("BFS distance: " + BfsIterative.findShortestDistance(graph, startNode, endNode));

        AdjacencyList maximalMatching = MaximalMatching.getMaximalMatching(bipartiteGraphGroup1, bipartiteGraphGroup2);
        System.out.println("Maximum matching: ");
        for (String node : bipartiteGraphGroup1.keySet()) {
            if (maximalMatching.get(node) != null) {
                System.out.println(node + " <-> " + maximalMatching.get(node).get(0));
            }
        }
        System.out.println("Maximum number of distinct pairings: " +
                MaximalMatching.getMaximumDistinctPairCount(bipartiteGraphGroup1, bipartiteGraphGroup2));
    }

    private static void processWeightedGraphs() {
        WeightedAdjacencyList directedAdjacencyList = getDirectedAdjacencyList();
        WeightedAdjacencyList undirectedAdjacencyList = getUndirectedAdjacencyList();

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
        for (Edge edge : kruskalMst.getEdges()) {
            System.out.println(edge.getNode1() + edge.getNode2() + ": " + edge.getWeight());
        }
        System.out.println("Kruskal total weight: " + Kruskal.getTotalMstWeight(directedAdjacencyList));

        System.out.println("Prim:");
        WeightedAdjacencyList primMst = Prim.getMinimumSpanningTree(undirectedAdjacencyList);
        for (Edge edge : primMst.getEdges()) {
            System.out.println(edge.getNode1() + edge.getNode2() + ": " + edge.getWeight());
        }
        System.out.println("Prim total weight: " + Prim.getTotalMstWeight(undirectedAdjacencyList));

        System.out.println("Chinese Postman shortest traversal weight:" + ChinesePostman.findShortestTraversalWeight(undirectedAdjacencyList));

    }

    private static AdjacencyList getBipartiteGroup1AdjacencyList() {
        AdjacencyList group1 = new AdjacencyList();
        // Graph from 7.2 Example 5 in Edexcel A level D1
        group1.put("Pat", List.of("cakes", "flowers", "fruit"));
        group1.put("Ramin", List.of("cakes", "preserves"));
        group1.put("Sze Ting", List.of("cakes", "fruit"));
        group1.put("Tom", List.of("fruit"));
        group1.put("Will", List.of("flowers", "preserves", "vegetables"));
        return group1;
    }

    private static AdjacencyList getBipartiteGroup2AdjacencyList() {
        AdjacencyList group2 = new AdjacencyList();
        // Graph from 7.2 Example 5 in Edexcel A level D1
        group2.put("cakes", List.of("Pat", "Ramin", "Sze Ting"));
        group2.put("flowers", List.of("Pat", "Will"));
        group2.put("fruit", List.of("Pat", "Sze Ting", "Tom"));
        group2.put("preserves", List.of("Ramin", "Will"));
        group2.put("vegetables", List.of("Will"));
        return group2;
    }

//    private static AdjacencyList getBipartiteGroup1AdjacencyList() {
//        AdjacencyList group1 = new AdjacencyList();
//        // Graph from 7B Q5 in Edexcel A level D1
//        group1.put("A", List.of("T", "R"));
//        group1.put("B", List.of("S", "R", "W"));
//        group1.put("C", List.of("U", "S"));
//        group1.put("D", List.of("V", "R"));
//        group1.put("E", List.of("T", "V"));
//        group1.put("F", List.of("V"));
//        return group1;
//    }
//
//    private static AdjacencyList getBipartiteGroup2AdjacencyList() {
//        AdjacencyList group2 = new AdjacencyList();
//        // Graph from 7B Q5 in Edexcel A level D1
//        group2.put("R", List.of("A", "B", "D"));
//        group2.put("S", List.of("B", "C"));
//        group2.put("T", List.of("A", "E"));
//        group2.put("U", List.of("C"));
//        group2.put("V", List.of("D", "E", "F"));
//        group2.put("W", List.of("B"));
//        return group2;
//    }

    private static WeightedAdjacencyList getDirectedAdjacencyList() {
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
        return directedAdjacencyList;
    }

    private static WeightedAdjacencyList getUndirectedAdjacencyList() {
        // Undirected version of graph from 3.4 example 7 in Edexcel A level D1
        WeightedAdjacencyList undirectedAdjacencyList = new WeightedAdjacencyList();
        undirectedAdjacencyList.addDirectedEdge("A", "B", 5.0);
        undirectedAdjacencyList.addDirectedEdge("A", "C", 2.0);
        undirectedAdjacencyList.addDirectedEdge("A", "E", 5.0);
        undirectedAdjacencyList.addDirectedEdge("B", "C", 2.0);
        undirectedAdjacencyList.addDirectedEdge("B", "D", 4.0);
        undirectedAdjacencyList.addDirectedEdge("B", "A", 5.0);
        undirectedAdjacencyList.addDirectedEdge("C", "B", 2.0);
        undirectedAdjacencyList.addDirectedEdge("C", "A", 2.0);
        undirectedAdjacencyList.addDirectedEdge("C", "D", 3.0);
        undirectedAdjacencyList.addDirectedEdge("C", "E", 5.0);
        undirectedAdjacencyList.addDirectedEdge("D", "B", 4.0);
        undirectedAdjacencyList.addDirectedEdge("D", "C", 3.0);
        undirectedAdjacencyList.addDirectedEdge("D", "E", 1.0);
        undirectedAdjacencyList.addDirectedEdge("D", "F", 9.0);
        undirectedAdjacencyList.addDirectedEdge("D", "G", 11.0);
        undirectedAdjacencyList.addDirectedEdge("E", "A", 5.0);
        undirectedAdjacencyList.addDirectedEdge("E", "C", 5.0);
        undirectedAdjacencyList.addDirectedEdge("E", "D", 1.0);
        undirectedAdjacencyList.addDirectedEdge("E", "F", 8.0);
        undirectedAdjacencyList.addDirectedEdge("E", "I", 14.0);
        undirectedAdjacencyList.addDirectedEdge("F", "E", 8.0);
        undirectedAdjacencyList.addDirectedEdge("F", "D", 9.0);
        undirectedAdjacencyList.addDirectedEdge("F", "G", 1.0);
        undirectedAdjacencyList.addDirectedEdge("F", "H", 5.0);
        undirectedAdjacencyList.addDirectedEdge("F", "I", 7.0);
        undirectedAdjacencyList.addDirectedEdge("G", "D", 11.0);
        undirectedAdjacencyList.addDirectedEdge("G", "F", 1.0);
        undirectedAdjacencyList.addDirectedEdge("G", "H", 2.0);
        undirectedAdjacencyList.addDirectedEdge("H", "F", 5.0);
        undirectedAdjacencyList.addDirectedEdge("H", "G", 2.0);
        undirectedAdjacencyList.addDirectedEdge("H", "I", 2.0);
        undirectedAdjacencyList.addDirectedEdge("I", "E", 14.0);
        undirectedAdjacencyList.addDirectedEdge("I", "F", 7.0);
        undirectedAdjacencyList.addDirectedEdge("I", "H", 2.0);
        return undirectedAdjacencyList;
    }
}
