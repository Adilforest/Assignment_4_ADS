package graphs;

import java.util.*;

/**
 * The {@code Dijkstra} class represents a data type for
 * performing Dijkstra's algorithm from a source vertex to
 * find the shortest path to all other vertices in a weighted graph.
 *
 * @param <Vertex> the type of vertices in the graph
 */
public class Dijkstra<Vertex> extends Search<Vertex> {
    private final Set<Vertex> unsettledNodes;
    private final Map<Vertex, Double> distances;
    private final WeightedGraph<Vertex> graph;

    /**
     * Initializes Dijkstra's algorithm from the source vertex in the given weighted graph.
     *
     * @param graph  the weighted graph to search
     * @param source the source vertex
     */
    public Dijkstra(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    /**
     * Performs Dijkstra's algorithm to compute the shortest path from the source to all vertices.
     *
     * Time complexity: O(V^2), where V is the number of vertices.
     * Using a priority queue (e.g., a binary heap) can reduce the time complexity to O(E + V log V).
     */
    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Vertex neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    /**
     * Returns the distance between two vertices in the graph.
     *
     * @param node   the source vertex
     * @param target the target vertex
     * @return the distance between {@code node} and {@code target}
     * @throws RuntimeException if the edge is not found
     */
    private double getDistance(Vertex node, Vertex target) {
        for (Edge<Vertex> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }

        throw new RuntimeException("Not found!");
    }

    /**
     * Returns the vertex with the minimum weight from the given set of vertices.
     *
     * @param vertices the set of vertices to check
     * @return the vertex with the minimum weight
     */
    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        for (Vertex vertex : vertices) {
            if (minimum == null) {
                minimum = vertex;
                continue;
            }

            if (getShortestDistance(vertex) < getShortestDistance(minimum))
                minimum = vertex;
        }

        return minimum;
    }

    /**
     * Returns the shortest distance to the given destination vertex.
     *
     * @param destination the destination vertex
     * @return the shortest distance to {@code destination}
     */
    private double getShortestDistance(Vertex destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}
