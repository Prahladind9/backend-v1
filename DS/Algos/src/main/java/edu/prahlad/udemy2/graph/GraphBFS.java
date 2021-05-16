package edu.prahlad.udemy2.graph;

import java.util.*;

/**
 * BFS Recursively, Iteratively
 */
public class GraphBFS extends Graph {

    public List<String> breadthFirstIteratively(final String startVertex){
        List<String> queue = new ArrayList<>();
        final List<String> result = new ArrayList<>();
        final Map<String, Boolean> visited = new HashMap<>();
        String currentVertex;

        queue.add(startVertex);
        visited.put(startVertex, true);

        while (queue.size() > 0){
            currentVertex = queue.remove(0);
            result.add(currentVertex);

            this.adjacencyList
                    .get(currentVertex)
                    .forEach(
                            neighbour -> {
                                if(visited.get(neighbour) == null || !visited.get(neighbour)){
                                    visited.put(neighbour, true);
                                    queue.add(neighbour);
                                }
                            }
                    );
        }

        return result;

    }


    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();
        graph.getInitializedGraph(graph);
        System.out.println(graph.breadthFirstIteratively("A"));

    }


}
