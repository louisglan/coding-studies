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
        SearchContext context = new SearchContext(adjacencyList, endNode, visitedPositions, path);
        return search(context, startNode);
    }

    private static ArrayList<String> search(SearchContext context, String currentNode) {
        context.visitedPositions.add(currentNode);
        for (String neighbour : context.adjacencyList.get(currentNode)) {
            if (!context.visitedPositions.contains(neighbour)) search(context, neighbour);
        }
        if (!context.path.isEmpty()) {
            context.path.addFirst(currentNode);
        }
        if (currentNode.equals(context.endNode)) {
            context.path.add(currentNode);
        }
        return context.path;
    }

    private record SearchContext(
            AdjacencyList adjacencyList,
            String endNode,
            ArrayList<String> visitedPositions,
            ArrayList<String> path) {}
}