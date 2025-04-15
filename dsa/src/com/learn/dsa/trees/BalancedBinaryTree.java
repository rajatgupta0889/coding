package com.learn.dsa.trees;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {

        if(root == null){
            return new int[]{1, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        boolean balanced = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1;
        int height = Math.max(left[1], right[1]) + 1;

        return new int[]{balanced ? 1 : 0, height};
    }

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5));
        boolean isBalanced = balancedBinaryTree.isBalanced(root);
        System.out.println("Is the binary tree balanced? " + isBalanced); // Output: true
    }
}
