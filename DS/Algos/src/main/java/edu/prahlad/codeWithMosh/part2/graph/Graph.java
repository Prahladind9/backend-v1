package edu.prahlad.codeWithMosh.part2.graph;

import java.util.*;

//Directed Graph
public class Graph {
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

    final private Map<String, Node> nodes = new HashMap<>();
    final private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(final String label) {
        final var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(final String from, final String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }


    public void removeNode(final String label) {
        var node = nodes.get(label);
        if (node == null) return;

        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(node);

    }

    public void removeEdge(final String from, final String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null) return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }


    public void traverseDepthFirst(final String root) {
        final var node = nodes.get(root);
        if (node == null) return;
//        traverseDepthFirstRecursive(node, new HashSet<>());
        traverseDepthFirstIterative(node);
    }

    public void traverseDepthFirstRecursive(final Node root, final Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (var node : adjacencyList.get(root))
            if (!visited.contains(node))
                traverseDepthFirstRecursive(node, visited);
    }

    public void traverseDepthFirstIterative(final Node node) {
        final Set<Node> visited = new HashSet<>();

        final Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            var current = stack.pop();
            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour))
                    stack.push(neighbour);
            }
        }
    }

    public void traverseBreadthFirst(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            var current = queue.remove();
            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour))
                    queue.add(neighbour);

            }
        }
    }

    public List<String> topologicalSort() {
        final Set<Node> visited = new HashSet<>();
        final Stack<Node> stack = new Stack<>();
        for (var node : nodes.values())
            topologicalSort(node, visited, stack);

        final List<String> sorted = new ArrayList<>();

        while (!stack.empty())
            sorted.add(stack.pop().label);

        return sorted;
    }

    private void topologicalSort(final Node node,
                                 final Set<Node> visited,
                                 final Stack<Node> stack) {
        if (visited.contains(node)) return;

        visited.add(node);
        for (var neighbour : adjacencyList.get(node))
            topologicalSort(neighbour, visited, stack);

        stack.push(node);
    }

    public boolean hasCycle() {
        final Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());
        final Set<Node> visiting = new HashSet<>();
        final Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            var current = all.iterator().next();
            if(hasCycle(current, all, visiting, visited)) return true;
        }

        return false;
    }

    private boolean hasCycle(final Node node,
                             final Set<Node> all,
                             final Set<Node> visiting,
                             final Set<Node> visited) {
        all.remove(node);
        visiting.add(node);
        for (var neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour)) continue;
            if (visiting.contains(neighbour)) return true;

            if (hasCycle(neighbour, all, visiting, visited)) return true;
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }

}
