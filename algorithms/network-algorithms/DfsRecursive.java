import java.util.ArrayList;

/*
Some notes on Dfs:
It uses lifo
It is not possible to guarantee an optimal solution on dfs. Bfs will guarantee an optimal solution on unweighted graphs.
Hence, I am just implementing finding any route
 */
public class DfsRecursive{
    public static ArrayList<String> findRoute(AdjacencyList adjacencyList, String startNode, String endNode) {
        ArrayList<String> visitedPositions = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        return search(adjacencyList, startNode, endNode, visitedPositions, path);
    }

    private static ArrayList<String> search(AdjacencyList adjacencyList, String currentNode, String endNode, ArrayList<String> visitedPositions, ArrayList<String> path) {
        visitedPositions.add(currentNode);
        for (String neighbour : adjacencyList.get(currentNode)) {
            if (!visitedPositions.contains(neighbour)) search(adjacencyList, neighbour, endNode, visitedPositions, path);
        }
        if (!path.isEmpty()) {
            path.addFirst(currentNode);
        }
        if (currentNode.equals(endNode)) {
            path.add(currentNode);
        }
        return path;
    }
}