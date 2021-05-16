package edu.prahlad.udemy2.graph;

import java.util.*;

/**
 * DFS Recursively, Iteratively
 */
public class GraphDFS extends Graph {

    public List<String> depthFirstRecursive(final String startVertex) {
        final List<String> result = new ArrayList<>();
        final Map<String, Boolean> visited = new HashMap<>();
        dfs(startVertex, result, visited);
        return result;
    }

    private void dfs(String vertex, final List<String> result, final Map<String, Boolean> visited) {
        if (vertex == null) return;

        visited.put(vertex, true);
        result.add(vertex);
        this.adjacencyList
                .get(vertex)
                .forEach(
                        neighbour -> {
                             if(visited.get(neighbour) == null || !visited.get(neighbour)){
                                 dfs(neighbour, result, visited);
                                 //System.out.println(neighbour);
                             }
                        }
                );
    }

    public List<String> depthFirstIteratively(final String startVertex){
        Stack<String> stack = new Stack<>();
        final List<String> result = new ArrayList<>();
        final Map<String, Boolean> visited = new HashMap<>();
        String currentVertex;

        stack.push(startVertex);
        visited.put(startVertex, true);

        while (stack.size() > 0){
//            System.out.println(stack);
            currentVertex = stack.pop();
            result.add(currentVertex);

            this.adjacencyList
                    .get(currentVertex)
                    .forEach(
                            neighbour -> {
                                if(visited.get(neighbour) == null || !visited.get(neighbour)){
                                    visited.put(neighbour, true);
                                    stack.push(neighbour);
                                }
                            }
                    );
        }

        return result;

    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS();
        graph.getInitializedGraph(graph);
        System.out.println(graph.depthFirstRecursive("A"));
        System.out.println(graph.depthFirstIteratively("A"));
    }
}
