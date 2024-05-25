
// Custom graph class for unweighted edges
class MyGraph<V> extends WeightedGraph<V> {
    public MyGraph(boolean directed) {
        super(directed);
    }

    // Add an edge with a default weight of 1.0
    public void addEdge(V source, V dest) {
        addEdge(source, dest, 1.0);
    }
}
