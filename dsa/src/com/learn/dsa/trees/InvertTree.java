package com.learn.dsa.trees;

public class InvertTree {

    /**
     * https://leetcode.com/problems/invert-binary-tree/
     * 226. Invert Binary Tree
     * */

    public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            root.left = right;
            root.right = left;

            return root;
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode invertedRoot = invertTree.invertTree(root);
        // Print the inverted tree (in-order traversal)
        printInOrder(invertedRoot);
    }

    private static void printInOrder(TreeNode invertedRoot) {

            if(invertedRoot == null) {
                return;
            }
            System.out.print(invertedRoot.val + " ");
            printInOrder(invertedRoot.left);
            printInOrder(invertedRoot.right);


    }
}
