package com.learn.dsa.trees;

public class IsSubTree {

    /**
     * https://leetcode.com/problems/subtree-of-another-tree/
     * 572. Subtree of Another Tree
     * */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
           if(subRoot == null)
               return true;
           if(root == null)
               return false;

           if(isSameTree(root, subRoot)){
                return true;
           }
           return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p != null && q != null && p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;

    }

    public static void main(String[] args) {
        IsSubTree isSubTree = new IsSubTree();
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, null, new TreeNode(0))), new TreeNode(5));
    }
}
