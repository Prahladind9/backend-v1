package edu.prahlad.udemy2.graph.dijkstra;

import java.util.*;

class NodeV {
    String val;
    Integer priority;

    public NodeV(String val, int priority) {
        this.val = val;
        this.priority = priority;
    }

    public String getVal() {
        return val;
    }

    public Integer getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Value{" +
                "val='" + val + '\'' +
                ", value=" + priority +
                '}';
    }
}

public class PriorityQueue {
    List<NodeV> nodeVS;

    public PriorityQueue() {
        this.nodeVS = new ArrayList<>();
    }

    public void enqueue(String val, Integer priority){
        this.nodeVS.add(new NodeV(val, priority));
        this.sort();
    }

    public NodeV dequeue(){
        if(this.nodeVS.size() == 0) return null;
        return this.nodeVS.remove(0);
    }

    private void sort(){
        this.nodeVS.sort(Comparator.comparing(NodeV::getPriority));
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "values=" + nodeVS +
                '}';
    }

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.enqueue("A", 4);
        q.enqueue("B", 34);
        q.enqueue("C", 8);
        q.enqueue("D", 6);
        System.out.println(q);
        System.out.println(q.dequeue());
    }
}
