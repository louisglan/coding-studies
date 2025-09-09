import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BfsIterative {
    public static ArrayList<String> findShortestRoute(AdjacencyList adjacencyList, String startNode, String endNode) {
        HashMap<String, String> parents = new HashMap<>();
        parents.put(startNode, null);
        ArrayList<String> visitedPositions = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.push(startNode);
        while (!queue.isEmpty()) {
            String currentNode = queue.pollLast();
            if (visitedPositions.contains(currentNode)) continue;
            visitedPositions.add(currentNode);
            if (currentNode.equals(endNode)) {
                return getRoute(currentNode, parents);
            }
            for (String neighbour : adjacencyList.get(currentNode)) {
                if (!visitedPositions.contains(neighbour)) {
                    queue.push(neighbour);
                    parents.putIfAbsent(neighbour, currentNode);
                }
            }
        }
        return new ArrayList<>();
    }

    private static ArrayList<String> getRoute(String currentNode, HashMap<String, String> parents) {
        ArrayList<String> route = new ArrayList<>();
        while (!(parents.get(currentNode) == null)) {
            route.addFirst(currentNode);
            currentNode = parents.get(currentNode);
        }
        route.addFirst(currentNode);
        return route;
    }

    public static int findShortestDistance(AdjacencyList adjacencyList, String startNode, String endNode) {
        return findShortestRoute(adjacencyList, startNode, endNode).size() - 1;
    }
}
