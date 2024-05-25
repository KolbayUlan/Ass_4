import java.util.*;

class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distTo; //Distance to each vertex

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        distTo = new HashMap<>();
        dijkstra(graph, source);
    }

    // Perform Dijkstra's algorithm from the source vertex
    private void dijkstra(WeightedGraph<V> graph, V source) {
        PriorityQueue<VertexDist<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(v -> v.dist));
        pq.add(new VertexDist<>(source, 0.0));
        distTo.put(source, 0.0);
        marked.put(source, true);

        while (!pq.isEmpty()) {
            VertexDist<V> vd = pq.poll();
            V v = vd.vertex;

            for (Map.Entry<Vertex<V>, Double> entry : graph.getVertex(v).getAdjacentVertices().entrySet()) {
                Vertex<V> w = entry.getKey();
                double weight = entry.getValue();

                if (!distTo.containsKey(w.getData()) || distTo.get(v) + weight < distTo.get(w.getData())) {
                    distTo.put(w.getData(), distTo.get(v) + weight);
                    edgeTo.put(w.getData(), v);
                    pq.add(new VertexDist<>(w.getData(), distTo.get(w.getData())));
                    marked.put(w.getData(), true);
                }
            }
        }
    }

    private static class VertexDist<V> {
        V vertex;
        double dist;

        VertexDist(V vertex, double dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    // Get the distance to a given vertex
    public double distTo(V v) {
        return distTo.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}
