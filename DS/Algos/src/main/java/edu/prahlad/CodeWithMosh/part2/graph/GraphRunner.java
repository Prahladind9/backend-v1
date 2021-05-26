package edu.prahlad.CodeWithMosh.part2.graph;

public class GraphRunner {

    public static void main(String[] args) {
        final var graph = new Graph();
//        example(graph);
//        topologicalSortExample(graph);

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");
        System.out.println(graph.hasCycle());//No Cycle
        graph.addEdge("C", "A");
        System.out.println(graph.hasCycle());//true has Cycle
    }

    private static void topologicalSortExample(Graph graph) {
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");
        System.out.println(graph.topologicalSort());
    }

    private static void example(Graph graph) {
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");
        graph.traverseDepthFirst("A");
        graph.traverseBreadthFirst("A");
//        graph.traverseDepthFirst("G"); //EdgeCase

        graph.addEdge("A", "D");
        //graph.addEdge("A", "F"); //EdgeCase - Illegal Argument Exception
        graph.print();
        graph.removeEdge("A", "C");
        graph.removeEdge("A", "E");
        graph.print();
        graph.removeNode("B");
        graph.print();
        graph.removeNode("A");
        graph.print();
    }
}
