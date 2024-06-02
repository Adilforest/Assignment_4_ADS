package graphs;

import java.util.Objects;

/**
 * The {@code Edge} class represents a weighted edge in a graph.
 *
 * @param <Vertex> the type of vertices in the graph
 */
public class Edge<Vertex> {
    private Vertex source;
    private Vertex dest;
    private Double weight;

    /**
     * Initializes an edge with the given source vertex, destination vertex, and weight.
     *
     * @param source the source vertex
     * @param dest   the destination vertex
     * @param weight the weight of the edge
     */
    public Edge(Vertex source, Vertex dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    /**
     * Initializes an edge with the given source vertex and destination vertex.
     *
     * @param source the source vertex
     * @param dest   the destination vertex
     */
    public Edge(Vertex source, Vertex dest) {
        this.source = source;
        this.dest = dest;
    }

    /**
     * Sets the source vertex of the edge.
     *
     * @param source the source vertex
     */
    public void setSource(Vertex source) {
        this.source = source;
    }

    /**
     * Returns the source vertex of the edge.
     *
     * @return the source vertex
     */
    public Vertex getSource() {
        return source;
    }

    /**
     * Sets the destination vertex of the edge.
     *
     * @param dest the destination vertex
     */
    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    /**
     * Returns the destination vertex of the edge.
     *
     * @return the destination vertex
     */
    public Vertex getDest() {
        return dest;
    }

    /**
     * Sets the weight of the edge.
     *
     * @param weight the weight of the edge
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Returns the weight of the edge.
     *
     * @return the weight of the edge
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(dest, edge.dest);
    }
}
