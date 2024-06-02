package graphs;

/**
 * The {@code DepthFirstSearch} class represents a data type for
 * performing a depth-first search from a source vertex to
 * discover all vertices in a graph that are reachable from the source vertex.
 *
 * @param <Vertex> the type of vertices in the graph
 */
public class DepthFirstSearch<Vertex> extends Search<Vertex> {

    /**
     * Initializes a depth-first search from the source vertex in the given graph.
     *
     * @param graph  the graph to search
     * @param source the source vertex
     */
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source);
    }

    /**
     * Performs a depth-first search in the given graph starting from the given vertex.
     *
     * @param graph   the graph to search
     * @param current the starting vertex
     *
     * Time complexity: O(V + E), where V is the number of vertices
     * and E is the number of edges in the graph.
     */
    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);

        for (Vertex v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}
