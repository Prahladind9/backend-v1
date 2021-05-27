package edu.prahlad.CodeWithMosh.part2.graphWeighted;

import java.util.*;

//Undirected Graph
public class WeightedGraphWithOOPs {
    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(final String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
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

    public void addNode(final String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(final String from, final String to, int weight) {
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var targets = node.getEdges();
            if (!targets.isEmpty())
                System.out.println(node + " is connected to " + targets);
        }
    }

    //Dijkstra's Algorithm > greedy algo > always looks for optimal solution
    //Not useful for cycle detection
    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    //Priority Queue
    public Path getShortestPath(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        final Map<Node, Integer> distances = new HashMap<>();
        final Set<Node> visited = new HashSet<>();
        final Map<Node, Node> previousNodes = new HashMap<>();
        final PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );

        //Initialize
        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);
        queue.add(new NodeEntry(fromNode, 0));

        //BFS
        while (!queue.isEmpty()) {
            var current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.remove(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        //print the shortest path - using Stack to achieve the same
        return buildPath(toNode, previousNodes);
    }

    private Path buildPath(Node toNode, Map<Node, Node> previousNodes) {
        final Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = previousNodes.get(toNode);
        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while (!stack.isEmpty())
            path.add(stack.pop().label);
        return path;
    }

    //Cyclic graph detection > hasCycle
    public boolean hasCycle() {
        final Set<Node> visited = new HashSet<>();
        for (var node : nodes.values()) {
            if (!visited.contains(node))
                if (hasCycle(node, null, visited))
                    return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);
        for (var edge : node.getEdges()) {
            if (edge.to == parent)
                continue;

            if (visited.contains(edge.to)) //previously visited node
                return true;

            if (hasCycle(edge.to, node, visited)) return true;
        }

        return false;
    }

    //Spanning Tree > Edges = N-1
    //Prim's Algorithm > finding Minimum Spanning Tree
    public WeightedGraphWithOOPs getMinimumSpanningTree() {
        var tree = new WeightedGraphWithOOPs();
        if(nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight)
        );

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);
        
        if(edges.isEmpty())
            return tree;

        while (tree.nodes.size() < nodes.size()) {
            var minEdge = edges.remove();
            var nextNode = minEdge.to;
            if (tree.containsNode(nextNode.label))
                continue;

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

            for (var edge : nextNode.getEdges())
                if (!tree.containsNode(edge.to.label))
                    edges.add(edge);
        }

        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}