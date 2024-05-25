public class Main {
    public static void main(String[] args) {
        // Create a directed weighted graph
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        // Perform Dijkstra's search from "Almaty"
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        // Output the path to "Kyzylorda"
        outputPath(djk, "Kyzylorda");

        System.out.println("--------------------------------");

        // Create a directed unweighted graph
        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        // Perform Depth First Search from "Almaty"
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        // Output the path to "Kyzylorda"
        outputPath(dfs, "Kyzylorda");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        // Perform Breadth First Search from "Almaty"
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        // Output the path to "Kyzylorda"
        outputPath(bfs, "Kyzylorda");
    }

    // Fill the unweighted graph with edges
    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("Almaty", "Astana"); // 16 - 19
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
    }

    // Fill the weighted graph with edges
    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    // Output the path from the source to the target
    public static void outputPath(Search<String> search, String key) {
        Iterable<String> path = search.pathTo(key);
        if (path != null) {
            for (String v : path) {
                System.out.print(v + " -> ");
            }
        } else {
            System.out.println("No path found");
        }
        System.out.println();
    }
}


