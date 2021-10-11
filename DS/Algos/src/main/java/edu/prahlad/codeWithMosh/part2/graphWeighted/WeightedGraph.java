package edu.prahlad.codeWithMosh.part2.graphWeighted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Undirected Graph
public class WeightedGraph {
    private class Node {
        private String label;

        public Node(final String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    final private Map<String, Node> nodes = new HashMap<>();
    final private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(final String label) {
        final var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(final String from, final String to, int weight) {
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(
                new Edge(fromNode, toNode, weight));

        adjacencyList.get(toNode).add(
                new Edge(toNode, fromNode, weight));
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }


}
