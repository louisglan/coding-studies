import java.util.ArrayList;
import java.util.LinkedList;

public class BfsIterative {
    public static ArrayList<String> findRoute(AdjacencyList adjacencyList, String startNode, String endNode) {
        ArrayList<String> visitedPositions = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.push(startNode);
        while (!queue.isEmpty()) {
            String currentNode = queue.pollLast();
            if (visitedPositions.contains(currentNode)) continue;
            visitedPositions.add(currentNode);
            path.add(currentNode);
            if (currentNode.equals(endNode)) {
                return path;
            }
            for (String neighbour : adjacencyList.get(currentNode)) {
                if (!visitedPositions.contains(neighbour)) queue.push(neighbour);
            }
        }
        return path;
    }
}
