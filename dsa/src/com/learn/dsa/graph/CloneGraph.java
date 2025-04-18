package com.learn.dsa.graph;

import java.util.HashMap;

public class CloneGraph {
    /*
     * https://leetcode.com/problems/clone-graph/
     * 133. Clone Graph
     * */

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node node, HashMap<Node, Node> map) {
        if(map.containsKey(node)){
            return map.get(node);
        }

        Node cloneNode = new Node(node.val);

        map.put(node, cloneNode);
        for(Node neighbors: node.neighbors){
            cloneNode.neighbors.add(dfs(neighbors, map));
        }

        return cloneNode;
    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedGraph = cloneGraph.cloneGraph(node1);
        System.out.println(clonedGraph.val); // Output: 1
    }
}
