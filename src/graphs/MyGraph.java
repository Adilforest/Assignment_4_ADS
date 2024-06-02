package graphs;

import java.util.*;

/**
 * The {@code MyGraph} class represents an undirected or directed graph.
 * It supports adding vertices and edges, and provides methods to query
 * the graph's structure.
 *
 * @param <VertexData> the type of data stored in the vertices
 */
public class MyGraph<VertexData> {
    private final boolean undirected;
    private final Map<VertexData, Vertex<VertexData>> map = new HashMap<>();

    /**
     * Initializes an undirected graph.
     */
    public MyGraph() {
        this(true);
    }

    /**
     * Initializes a graph, directed or undirected.
     *
     * @param undirected {@code true} if the graph is undirected, {@code false} if directed
     */
    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param v the vertex data to add
     */
    public void addVertex(VertexData v) {
        if (hasVertex(v)) return;
        map.put(v, new Vertex<>(v));
    }

    /**
     * Adds an edge between the source and destination vertices.
     * If the graph is undirected, also adds the reverse edge.
     *
     * @param source the source vertex
     * @param dest   the destination vertex
     */
    public void addEdge(VertexData source, VertexData dest) {
        if (!hasVertex(source)) addVertex(source);
        if (!hasVertex(dest)) addVertex(dest);
        if (hasEdge(source, dest) || source.equals(dest)) return;

        Vertex<VertexData> sV = map.get(source);
        Vertex<VertexData> dV = map.get(dest);

        sV.addAdjacentVertex(dV, 1);

        if (undirected) dV.addAdjacentVertex(sV, 1);
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return the number of vertices
     */
    public int getVerticesCount() {
        return map.size();
    }

    /**
     * Returns the number of edges in the graph.
     *
     * @return the number of edges
     */
    public int getEdgesCount() {
        int count = 0;
        for (Vertex<VertexData> v : map.values()) {
            count += v.getAdjacencyList().size();
        }

        if (undirected) count /= 2;

        return count;
    }

    /**
     * Checks if the graph contains the specified vertex.
     *
     * @param v the vertex data
     * @return {@code true} if the graph contains the vertex, {@code false} otherwise
     */
    public boolean hasVertex(VertexData v) {
        return map.containsKey(v);
    }

    /**
     * Checks if the graph contains an edge between the specified vertices.
     *
     * @param source the source vertex
     * @param dest   the destination vertex
     * @return {@code true} if the edge exists, {@code false} otherwise
     */
    public boolean hasEdge(VertexData source, VertexData dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).hasEdge(map.get(dest));
    }

    /**
     * Returns the adjacency list of the specified vertex.
     *
     * @param v the vertex data
     * @return a list of adjacent vertices
     */
    public List<VertexData> adjacencyList(VertexData v) {
        if (!hasVertex(v)) return null;
        return map.get(v).getAdjacencyList();
    }
}
