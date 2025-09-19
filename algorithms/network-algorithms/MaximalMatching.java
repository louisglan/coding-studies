import java.util.ArrayList;
import java.util.List;

public class MaximalMatching {
    public static AdjacencyList getMaximalMatching(AdjacencyList group1, AdjacencyList group2) {
        AdjacencyList initialMatching = findInitialMatching(group1);
        if (initialMatching.size() == group1.size() || initialMatching.size() == group2.size()) return initialMatching;
        for (String node : group1.keySet()) {
            if (initialMatching.get(node) == null) {
                List<String> visitedNodes = new ArrayList<>();
                List<String> alternatingPath = attemptToFindAlternatingPath(
                        group1, group2, initialMatching, node, visitedNodes, false);
                if (!alternatingPath.isEmpty()) {
                    changeStatus(initialMatching, alternatingPath);
                }
            }
        }
        return initialMatching;
    }

    private static AdjacencyList findInitialMatching(AdjacencyList group1) {
        AdjacencyList initialMatching = new AdjacencyList();
        List<String> nodesInInitialMatching = new ArrayList<>();
        for (String node : group1.keySet()) {
            for (String partnerNode : group1.get(node)) {
                if (!nodesInInitialMatching.contains(node) && !nodesInInitialMatching.contains(partnerNode)) {
                    initialMatching.addEdge(node, partnerNode);
                    nodesInInitialMatching.add(node);
                    nodesInInitialMatching.add(partnerNode);
                }
            }
        }
        return initialMatching;
    }

    private static List<String> attemptToFindAlternatingPath(AdjacencyList currentGroup,
                                                             AdjacencyList partnerGroup,
                                                             AdjacencyList initialMatching,
                                                             String currentNode,
                                                             List<String> visitedNodes,
                                                             boolean shouldBeInMatching) {
        visitedNodes.add(currentNode);
        boolean isFirstNode = currentNode.equals(visitedNodes.get(0));
        if (!isNodeInMatching(initialMatching, currentNode) && !isFirstNode) {
            return visitedNodes;
        }
        for (String node : currentGroup.get(currentNode)) {
            boolean shouldInspectNode = shouldBeInMatching == isEdgeInMatching(initialMatching, currentNode, node);
            if (partnerGroup.get(node) != null && !visitedNodes.contains(node) && shouldInspectNode) {
                List<String> alternatingPath = attemptToFindAlternatingPath(
                        partnerGroup,
                        currentGroup,
                        initialMatching,
                        node,
                        new ArrayList<>(visitedNodes),
                        !shouldBeInMatching);
                if (!alternatingPath.isEmpty()) return alternatingPath;
            }
        }
        return new ArrayList<>();
    }

    private static boolean isEdgeInMatching(AdjacencyList initialMatching, String node1, String node2) {
        return initialMatching.containsKey(node1) && initialMatching.get(node1).contains(node2);
    }

    private static boolean isNodeInMatching(AdjacencyList initialMatching, String node) {
        return initialMatching.containsKey(node) || initialMatching.values().stream().map(partnerSet -> partnerSet.get(0)).toList().contains(node);
    }

    private static void changeStatus(AdjacencyList initialMatching, List<String> alternatingPath) {
        boolean isIn = false;
        for (int i = 0; i < alternatingPath.size() - 1; i++) {
            if (!isIn) {
                initialMatching.put(alternatingPath.get(i), List.of(alternatingPath.get(i + 1)));
                initialMatching.put(alternatingPath.get(i + 1), List.of(alternatingPath.get(i)));
            }
            isIn = !isIn;
        }
    }

    public static int getMaximumDistinctPairCount(AdjacencyList group1, AdjacencyList group2) {
        return getMaximalMatching(group1, group2).size() / 2;
    }
}
