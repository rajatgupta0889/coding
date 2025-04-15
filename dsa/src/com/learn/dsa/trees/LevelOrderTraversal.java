package com.learn.dsa.trees;

import java.util.*;

public class LevelOrderTraversal {

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     * 102. Binary Tree Level Order Traversal
     * */

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new java.util.HashMap<>();

        levelOrderHelper(root, 0, map);
        return new java.util.ArrayList<>(map.values());
    }

    private void levelOrderHelper(TreeNode root, int i, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        map.computeIfAbsent(i, k -> new java.util.ArrayList<>()).add(root.val);
        levelOrderHelper(root.left, i + 1, map);
        levelOrderHelper(root.right, i + 1, map);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();

            int size = queue.size();
            for(int i =0; i< size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(!level.isEmpty()){
                result.add(level);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> result = levelOrderTraversal.levelOrder2(root);
        System.out.println("Level Order Traversal: " + result); // Output: [[3], [9, 20], [15, 7]]
    }
}
