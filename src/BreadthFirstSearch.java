import java.util.*;

class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    // Perform BFS from the source vertex
    private void bfs(WeightedGraph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);
        marked.put(source, true);

        while (!queue.isEmpty()) {
            V v = queue.poll();
            Vertex<V> vertex = graph.getVertex(v);
            for (Vertex<V> w : vertex.getAdjacentVertices().keySet()) {
                if (!marked.getOrDefault(w.getData(), false)) {
                    queue.add(w.getData());
                    marked.put(w.getData(), true);
                    edgeTo.put(w.getData(), v);
                }
            }
        }
    }
}
