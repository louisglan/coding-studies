import java.util.ArrayList;
import java.util.Stack;

public class DfsIterative {
    public static ArrayList<String> findRoute(AdjacencyList adjacencyList, String startNode, String endNode) {
        ArrayList<String> visitedPositions = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(startNode);
        while (!stack.isEmpty()) {
            String currentNode = stack.pop();
            if (visitedPositions.contains(currentNode)) continue;
            visitedPositions.add(currentNode);
            path.add(currentNode);
            if (currentNode.equals(endNode)) {
                return path;
            }
            String[] neighbours = adjacencyList.get(currentNode);
            for (int i = neighbours.length - 1; i >=0; i--) {
                if (!visitedPositions.contains(neighbours[i])) stack.push(neighbours[i]);
            }
        }
        return path;
    }
}
