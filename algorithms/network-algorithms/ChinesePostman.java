import java.util.*;

public class ChinesePostman {
    // Finding the shortest path is relatively trivial (once the repeated path in graphs that aren't traversable)
    // might be worth returning the routes that should be doubled up
    public static Double findShortestTraversalWeight(WeightedAdjacencyList adjacencyList) {
        List<String> oddNodes = new ArrayList<>();
        for (String node : adjacencyList.keySet()) {
            if (adjacencyList.get(node).size() % 2 == 1) oddNodes.add(node);
        }
        Double graphWeight = adjacencyList.getEdges().stream().map(Edge::getWeight).reduce(0.0, Double::sum);
        if (oddNodes.isEmpty()) return graphWeight;
        Set<Set<AbstractMap.SimpleEntry<String, String>>> allOddNodePairSets = new HashSet<>();
        Set<AbstractMap.SimpleEntry<String, String>> initialOddNodePairSet = new HashSet<>();
        fillNodePairSets(oddNodes, allOddNodePairSets, initialOddNodePairSet);
        double shortestNodePairCombination = Double.MAX_VALUE;
        for (var oddNodePairSet : allOddNodePairSets) {
            Double totalDijkstraForSet = oddNodePairSet.stream()
                    .map(pair -> Dijkstra.getShortestDistance(adjacencyList, pair.getKey(), pair.getValue()))
                    .reduce(0.0, Double::sum);
            if (totalDijkstraForSet < shortestNodePairCombination) {
                shortestNodePairCombination = totalDijkstraForSet;
            }
        }
        return shortestNodePairCombination + graphWeight;
    }

    private static void fillNodePairSets(
            List<String> remainingOddNodes,
            Set<Set<AbstractMap.SimpleEntry<String, String>>> allOddNodePairSets,
            Set<AbstractMap.SimpleEntry<String, String>> oddNodePairSet) {
        for (int i = 1; i < remainingOddNodes.size(); i++) {
            Set<AbstractMap.SimpleEntry<String, String>> nodePairSetClone = new HashSet<>(oddNodePairSet);
            nodePairSetClone.add(new AbstractMap.SimpleEntry<>(remainingOddNodes.get(0), remainingOddNodes.get(i)));
            if (remainingOddNodes.size() == 2) {
                allOddNodePairSets.add(nodePairSetClone);
                return;
            }
            List<String> remainingOddNodesClone = new ArrayList<>(remainingOddNodes);
            remainingOddNodesClone.remove(i);
            remainingOddNodesClone.remove(0);
            fillNodePairSets(remainingOddNodesClone, allOddNodePairSets, nodePairSetClone);
        }
    }
}
