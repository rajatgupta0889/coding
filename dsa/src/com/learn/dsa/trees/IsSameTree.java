package com.learn.dsa.trees;

public class IsSameTree {
    /**
     * <a href="https://leetcode.com/problems/same-tree/">...</a>
     * 100. Same Tree
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {
        IsSameTree isSameTree = new IsSameTree();
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        boolean result = isSameTree.isSameTree(p, q);
        System.out.println("Are the trees same? " + result); // Output: true
    }
}
