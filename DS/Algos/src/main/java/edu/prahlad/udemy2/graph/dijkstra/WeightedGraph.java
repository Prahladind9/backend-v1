package edu.prahlad.udemy2.graph.dijkstra;

import java.util.*;

class Node {
    String node;
    int weight;

    public Node(String node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "node='" + node + '\'' +
                ", weight=" + weight +
                '}';
    }
}

public class WeightedGraph {
    Map<String, List<Node>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        this.adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2, int weight) {
        if (this.adjacencyList.get(vertex1) != null && this.adjacencyList.get(vertex2) != null) {
            this.adjacencyList.get(vertex1).add(new Node(vertex2, weight));
            this.adjacencyList.get(vertex2).add(new Node(vertex1, weight));
        }
    }

    public List<String> Dijkstra(String start, String finish) {
        final List<String> path = new ArrayList<>();
        final PriorityQueue nodes = new PriorityQueue();
        final Map<String, Integer> distances = new HashMap<>();
        final Map<String, String> previous = new HashMap<>();

        //build initial state
        this.adjacencyList.keySet().forEach(
                vertex -> {
                    if (vertex.equals(start)) {
                        distances.put(vertex, 0);
                        nodes.enqueue(vertex, 0);
                    } else {
                        distances.put(vertex, Integer.MAX_VALUE);
                        nodes.enqueue(vertex, Integer.MAX_VALUE);
                    }
                    previous.put(vertex, null);
                });

        //as long as there is something to visit
        while (nodes.nodeVS.size() > 0) {
            String smallest = nodes.dequeue().val;
            if (smallest.equals(finish)) {
                //We are done
                //Build ip path to return to end
                System.out.println(previous);
                while (previous.get(smallest) != null) {
                    path.add(smallest);
                    smallest = previous.get(smallest);
                }
                path.add(start);
                Collections.sort(path);
                break;
            }

            if (smallest != null ||
                    distances.get(smallest) != Integer.MAX_VALUE) {

                for (Node nextNode : this.adjacencyList.get(smallest)) {
                    //calculate new distance to neighbouring node
                    Integer candidate = distances.get(smallest) + nextNode.weight;
                    if (candidate < distances.get(nextNode.node)) {
                        //updating new smallest distance to neighbor
                        distances.put(nextNode.node, candidate);
                        //updating previous - How we got to neighbor
                        previous.put(nextNode.node, smallest);
                        //enqueue in priority queue with new priority
                        nodes.enqueue(nextNode.node, candidate);
                    }
                }
            }
        }

        return path;
    }

    @Override
    public String toString() {
        return "WeightedGraph{" +
                "adjacencyList=" + adjacencyList +
                '}';
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        System.out.println(graph);
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "E", 3);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "F", 4);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "F", 1);
        graph.addEdge("E", "F", 1);
        System.out.println(graph);
        System.out.println("Path > " + graph.Dijkstra("A", "E"));
        System.out.println("Path > " + graph.Dijkstra("A", "C"));
        System.out.println("Path > " + graph.Dijkstra("A", "F"));
    }

}
