import java.util.*;

abstract class Search<V> {
    protected Map<V, Boolean> marked; //Marked vertices
    protected Map<V, V> edgeTo; //Last edge on the path to a vertex
    protected final V source; // Source vertex

    public Search(V source) {
        this.source = source;
        this.marked = new HashMap<>();
        this.edgeTo = new HashMap<>();
    }

    // Check if there is a path to a given vertex
    public boolean hasPathTo(V v) {
        return marked.getOrDefault(v, false);
    }

    // Return the path to a given vertex
    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = v; x != source; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(source);
        return path;
    }

    // Clear the search state
    public void reset() {
        marked.clear();
        edgeTo.clear();
    }
}
