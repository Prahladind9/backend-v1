package edu.prahlad.codeWithMosh.part2.trees;

import java.util.*;

public class TreeBFS extends Tree{
    public void traverseLevelOrder(){
        for (int i = 0; i <= height(); i++) {
            for (var value: getNodesAtDistance(i))
                System.out.print(value + ", ");
        }
    }


    public void traverseLevelOrderRecursion(){
        List<List<Integer>> levels = new ArrayList<>();
        traverseLevelOrderHelper(root, 0, levels);
        System.out.println(Arrays.toString(levels.toArray()));
    }

    private void traverseLevelOrderHelper(Node node, int level, List<List<Integer>> levels){

        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.value);

        if(node.leftChild != null) traverseLevelOrderHelper(node.leftChild, level+1, levels);
        if(node.rightChild != null) traverseLevelOrderHelper(node.rightChild, level+1, levels);

    }

    public void traverseLevelOrderIterative(){
        List<List<Integer>> levels = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()){
            //start the current level
            levels.add(new ArrayList<>());

            //number if elements in the current level
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                Node node = queue.remove();

                levels.get(level).add(node.value);

                if(node.leftChild != null) queue.add(node.leftChild);
                if(node.rightChild != null) queue.add(node.rightChild);
            }
            level++;
        }
        System.out.println(Arrays.toString(levels.toArray()));
    }

    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS();
        tree.getInitializedTree(tree);
        System.out.println(tree);
        tree.traverseLevelOrder();
        System.out.println();
        tree.traverseLevelOrderRecursion();
        tree.traverseLevelOrderIterative();
    }
}
