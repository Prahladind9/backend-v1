package edu.prahlad.udemy2.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Undirected Graph
 */
public class Graph implements graphHelper{
    Map<String, List<String>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex){
        this.adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2){
        if(this.adjacencyList.get(vertex1) != null && this.adjacencyList.get(vertex2) != null){
            this.adjacencyList.get(vertex1).add(vertex2);
            this.adjacencyList.get(vertex2).add(vertex1);
        }
    }

    public void removeEdge(String vertex1, String vertex2){
        if(this.adjacencyList.get(vertex1) != null && this.adjacencyList.get(vertex2) != null){
            this.adjacencyList.get(vertex1).remove(vertex2);
            this.adjacencyList.get(vertex2).remove(vertex1);
        }
    }

    public void removeVertex(String vertex){
        this.adjacencyList.remove(vertex);
        for(String key: this.adjacencyList.keySet()){
            this.adjacencyList.get(key).remove(vertex);
        }
    }

    @Override
    public void initializeGraph(Graph graph) {
        graph.addVertex("Tokyo");
        graph.addVertex("NY");
        graph.addVertex("LA");
        graph.addVertex("HK");
        System.out.println(graph);
        graph.addEdge("NY", "LA");
        graph.addEdge("HK", "LA");
        graph.addEdge("Tokyo", "LA");
        System.out.println(graph);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjacencyList=" + adjacencyList +
                '}';
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.initializeGraph(graph);
        graph.getInitializedGraph(graph);
        graph.removeEdge("Tokyo", "LA");
        System.out.println(graph);
        graph.removeVertex("HK");
        System.out.println(graph);
    }


}
