import java.util.*;

class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices; //Map of vertices by their data
    private boolean directed; //Indicates if the graph is directed or not

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    // Add an edge with a weight between two vertices
    public void addEdge(V source, V dest, double weight) {
        Vertex<V> srcVertex = vertices.computeIfAbsent(source, Vertex::new);
        Vertex<V> destVertex = vertices.computeIfAbsent(dest, Vertex::new);

        srcVertex.addAdjacentVertex(destVertex, weight);
        if (!directed) {
            destVertex.addAdjacentVertex(srcVertex, weight);
        }
    }

    public Vertex<V> getVertex(V key) {
        return vertices.get(key);
    }

    public Set<V> getVertices() {
        return vertices.keySet();
    }

    // Get the weight of the edge between two vertices
    public double getEdgeWeight(V source, V dest) {
        Vertex<V> srcVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);
        return srcVertex.getWeightTo(destVertex);
    }

    // Check if the graph contains a given vertex
    public boolean hasVertex(V key) {
        return vertices.containsKey(key);
    }

    // Check if there is an edge between two vertices
    public boolean hasEdge(V source, V dest) {
        Vertex<V> srcVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);
        return srcVertex != null && destVertex != null && srcVertex.hasAdjacentVertex(destVertex);
    }

    // Clear all vertices from the graph
    public void reset() {
        vertices.clear();
    }
}
