package edu.prahlad.udemy2.graph;

@FunctionalInterface
public interface graphHelper {
    void initializeGraph(Graph graph);

    default void getInitializedGraph(Graph graph) {
         graph.addVertex("A");
         graph.addVertex("B");
         graph.addVertex("C");
         graph.addVertex("D");
         graph.addVertex("E");
         graph.addVertex("F");
         System.out.println(graph);
         graph.addEdge("A", "B");
         graph.addEdge("A", "C");
         graph.addEdge("B", "D");
         graph.addEdge("C", "E");
         graph.addEdge("D", "E");
         graph.addEdge("D", "F");
         graph.addEdge("E", "F");
         System.out.println(graph);
    }
}
