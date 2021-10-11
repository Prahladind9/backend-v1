package edu.prahlad.codeWithMosh.part2.graphWeighted;

public class WeightedGraphRunner {
    public static void main(String[] args) {
        //example();

        var graph = new WeightedGraphWithOOPs();
        /*graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 5);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "C", 4);;
        graph.print();
        System.out.println(graph.getShortestPath("A", "C"));
        System.out.println(graph.hasCycle());*/
        System.out.println(graph.getMinimumSpanningTree());
    }

    private static void example() {
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 2);
        graph.print();
    }
}
