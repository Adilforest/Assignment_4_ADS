package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The {@code BreadthFirstSearch} class represents a data type for
 * performing a breadth-first search from a source vertex to
 * discover all vertices in a graph that are reachable from the source vertex.
 *
 * @param <Vertex> the type of vertices in the graph
 */
public class BreadthFirstSearch<Vertex> extends Search<Vertex> {

    /**
     * Initializes a breadth-first search from the source vertex in the given graph.
     *
     * @param graph  the graph to search
     * @param source the source vertex
     */
    public BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        bfs(graph, source);
    }

    /**
     * Performs a breadth-first search in the given graph starting from the given vertex.
     *
     * @param graph   the graph to search
     * @param current the starting vertex
     *
     * Time complexity: O(V + E), where V is the number of vertices
     * and E is the number of edges in the graph.
     */
    private void bfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex v = queue.remove();

            for (Vertex vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
