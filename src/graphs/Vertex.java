package graphs;
import java.util.*;

/**
 * The {@code Vertex} class represents a vertex in a graph.
 * Each vertex contains data and maintains a list of adjacent vertices with corresponding edge weights.
 *
 * @param <V> the type of data stored in the vertex
 */
public class Vertex<V> {
    private static int nodeIndex = 0;
    private final int hash;
    private V data;
    private final Map<Vertex<V>, Double> adjacentVertices;

    /**
     * Initializes a vertex with the given data.
     *
     * @param data the data stored in the vertex
     */
    public Vertex(V data) {
        this.data = data;
        hash = nodeIndex++;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Returns the data stored in the vertex.
     *
     * @return the data
     */
    public V getData() {
        return data;
    }

    /**
     * Adds an adjacent vertex with the specified weight.
     *
     * @param destination the adjacent vertex
     * @param weight      the weight of the edge to the adjacent vertex
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    /**
     * Checks if there is an edge between this vertex and another vertex.
     *
     * @param other the other vertex
     * @return {@code true} if there is an edge, {@code false} otherwise
     */
    public boolean hasEdge(Vertex<V> other) {
        return adjacentVertices.get(other) != null;
    }

    /**
     * Returns a list of data from all adjacent vertices.
     *
     * @return a list of data from adjacent vertices
     */
    public List<V> getAdjacencyList() {
        List<V> res = new LinkedList<>();
        for (var i : adjacentVertices.keySet())
            res.add(i.getData());
        return res;
    }

    /**
     * Returns the weight of the edge between this vertex and another vertex, or {@code null} if no edge exists.
     *
     * @param other the other vertex
     * @return the weight of the edge, or {@code null} if no edge exists
     */
    public Double getEdgeWeight(Vertex<V> other) {
        if (!hasEdge(other))
            return null;
        return adjacentVertices.get(other);
    }

    /**
     * Returns the hash code for this vertex, which is based on a unique node index.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return hash;
    }
}
