import java.util.Stack;

public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);
        Stack<Vertex> stack = new Stack<>();
        stack.push(current);

        while (!stack.isEmpty()) {
            Vertex v = stack.pop();

            for (Vertex vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    stack.push(vertex);
                }
            }
        }
    }
}
