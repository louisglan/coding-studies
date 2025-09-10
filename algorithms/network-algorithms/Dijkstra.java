import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {
    public static ArrayList<String> findShortestRoute(WeightedAdjacencyList adjacencyList, String startNode, String endNode) {
        HashMap<String, Double> workingValues = new HashMap<>();
        HashMap<String, Double> finalValues = new HashMap<>();
        workingValues.put(startNode, 0.0);
        finalValues.put(startNode, 0.0);
        String currentNode = startNode;
        for (int i = 0; i < adjacencyList.keySet().size(); i++) {
            for (var neighbour : adjacencyList.get(currentNode)) {
                if (finalValues.get(neighbour.getKey()) != null) continue;
                var neighbourWorkingValue = workingValues.get(neighbour.getKey());
                var distanceThroughCurrentNodeToNeighbour = workingValues.get(currentNode) + neighbour.getValue();
                if (neighbourWorkingValue != null && neighbourWorkingValue < distanceThroughCurrentNodeToNeighbour)
                    continue;
                workingValues.put(neighbour.getKey(), distanceThroughCurrentNodeToNeighbour);
            }
            Double minFinalValue = Double.MAX_VALUE;
            String finalNode = "";
            for (String node : workingValues.keySet()) {
                if (finalValues.get(node) == null && workingValues.get(node) < minFinalValue) {
                    minFinalValue = workingValues.get(node);
                    finalNode = node;
                }
            }
            finalValues.put(finalNode, minFinalValue);
            currentNode = finalNode;
        }
        WeightedAdjacencyList backtrackingAdjacencyList = generateBacktrackingAdjacencyList(adjacencyList);
        return backtrack(backtrackingAdjacencyList, finalValues, endNode, startNode);
    }

    private static WeightedAdjacencyList generateBacktrackingAdjacencyList(WeightedAdjacencyList adjacencyList) {
        WeightedAdjacencyList backtrackingAdjacencyList = new WeightedAdjacencyList();
        for (var node : adjacencyList.keySet()) {
            for (var neighbour : adjacencyList.get(node)) {
                backtrackingAdjacencyList.addDirectedEdge(neighbour.getKey(), node, neighbour.getValue());
            }
        }
        return  backtrackingAdjacencyList;
    }

    private static ArrayList<String> backtrack(
            WeightedAdjacencyList backtrackingAdjacencyList,
            HashMap<String, Double> finalValues,
            String endNode,
            String startNode) {
        String currentNode = endNode;
        ArrayList<String> path = new ArrayList<>();
        path.add(currentNode);
        while (!currentNode.equals(startNode)) {
            currentNode = getNextBacktrackingNode(backtrackingAdjacencyList, finalValues, currentNode);
            path.addFirst(currentNode);
        }
        return path;
    }

    private static String getNextBacktrackingNode(WeightedAdjacencyList backtrackingAdjacencyList, HashMap<String, Double> finalValues, String currentNode) {
        for (var neighbour : backtrackingAdjacencyList.get(currentNode)) {
            if (finalValues.get(neighbour.getKey()) + neighbour.getValue() == finalValues.get(currentNode)) {
                return neighbour.getKey();
            }
        }
        return "May be better to throw an error here";
    }

    public static Double getShortestDistance(WeightedAdjacencyList adjacencyList, String startNode, String endNode) {
        ArrayList<String> path = findShortestRoute(adjacencyList, startNode, endNode);
        Double totalDistance = 0.0;
        for (int i = 0; i < path.size() - 1; i++) {
            for (var neighbour : adjacencyList.get(path.get(i))) {
                if (neighbour.getKey().equals(path.get(i + 1))) {
                    totalDistance += neighbour.getValue();
                }
            }
        }
        return totalDistance;
    }
}
