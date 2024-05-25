import java.util.*;

class Vertex<V> {
    private V data; //The data stored in the vertex
    private Map<Vertex<V>, Double> adjacentVertices; //Adjacent vertices and the weights of the edges connecting to them

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    // Add an adjacent vertex with a given weight
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    // Check if there is an edge to a given vertex
    public boolean hasAdjacentVertex(Vertex<V> destination) {
        return adjacentVertices.containsKey(destination);
    }

    // Get the weight of the edge to a given vertex
    public double getWeightTo(Vertex<V> destination) {
        return adjacentVertices.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
