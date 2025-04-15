package com.learn.dsa.trees;

public class DiameterOfBT {

    /**
     * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">...</a>
     * 543. Diameter of Binary Tree
     */

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];

        findHeight(root,diameter);

        return diameter[0];

    }

    private int findHeight(TreeNode root, int[] diameter) {

        if(root == null){
            return 0;
        }

        int leftHeight  = findHeight(root.left, diameter);
        int rightHeight  = findHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        DiameterOfBT diameterOfBT = new DiameterOfBT();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        int diameter = diameterOfBT.diameterOfBinaryTree(root);
        System.out.println("Diameter of Binary Tree: " + diameter); // Output: 3
    }
}
