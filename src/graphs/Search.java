package graphs;
import java.util.*;

/**
 * The {@code Search} class represents a data type for
 * performing search operations on a graph from a source vertex.
 *
 * @param <Vertex> the type of vertices in the graph
 */
public class Search<Vertex> {
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected final Vertex source;

    /**
     * Initializes the search with the given source vertex.
     *
     * @param source the source vertex
     */
    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    /**
     * Determines if there is a path from the source vertex to the specified vertex.
     *
     * @param v the vertex to check
     * @return {@code true} if there is a path, {@code false} otherwise
     */
    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    /**
     * Returns the path from the source vertex to the specified vertex, or {@code null} if no such path exists.
     *
     * @param v the destination vertex
     * @return an iterable of vertices representing the path, or {@code null} if no path exists
     */
    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;

        LinkedList<Vertex> ls = new LinkedList<>();
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }

        ls.push(source);

        return ls;
    }
}
