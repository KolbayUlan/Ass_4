class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    // Perform DFS from the source vertex
    private void dfs(WeightedGraph<V> graph, V v) {
        marked.put(v, true);
        Vertex<V> vertex = graph.getVertex(v);
        for (Vertex<V> w : vertex.getAdjacentVertices().keySet()) {
            if (!marked.getOrDefault(w.getData(), false)) {
                edgeTo.put(w.getData(), v);
                dfs(graph, w.getData());
            }
        }
    }
}
