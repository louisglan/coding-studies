import java.util.ArrayList;
import java.util.List;
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
            List<String> neighbours = adjacencyList.get(currentNode);
            for (int i = neighbours.size() - 1; i >=0; i--) {
                if (!visitedPositions.contains(neighbours.get(i))) stack.push(neighbours.get(i));
            }
        }
        return path;
    }
}
