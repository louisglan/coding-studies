import java.util.ArrayList;

public class NetworkAlgorithms {
    public static void main(String[] args) {
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

        System.out.println("DFS recursive:");
        ArrayList<String> dfsRecursivePath = DfsRecursive.findRoute(adjacencyList, "H", "A");
        for (String node : dfsRecursivePath) {
            System.out.println(node);
        }

        System.out.println("DFS iterative:");
        ArrayList<String> dfsIterativePath = DfsIterative.findRoute(adjacencyList, "H", "A");
        for (String node : dfsIterativePath) {
            System.out.println(node);
        }
    }
}
