package com.learn.dsa.trees;

public class IsValidBST {

    /**
     * <a href="https://leetcode.com/problems/validate-binary-search-tree/">...</a>
     * 98. Validate Binary Search Tree
     */

    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root,null, null);
    }

    private boolean isValidBSTUtil(TreeNode root, Integer low, Integer high) {
        if(root == null)
            return true;

        if( (low != null && root.val <= low) || (high != null && root.val >= high) )
            return false;

        return isValidBSTUtil(root.right, root.val, high) && isValidBSTUtil(root.left, low, root.val);

    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean result = isValidBST.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + result); // Output: true

        TreeNode invalidRoot = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean invalidResult = isValidBST.isValidBST(invalidRoot);
        System.out.println("Is the tree a valid BST? " + invalidResult); // Output: false
    }
}
