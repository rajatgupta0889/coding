package com.learn.dsa.trees;

public class MaximumDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthBinaryTree maximumDepthBinaryTree = new MaximumDepthBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int depth = maximumDepthBinaryTree.maxDepth(root);
        System.out.println("Maximum Depth: " + depth); // Output: 3
    }
}
