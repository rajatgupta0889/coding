package com.learn.dsa.trees;

public class LowestCommonAncestor {

    /**
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * 236. Lowest Common Ancestor of a Binary Tree
     * */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            } else if(root.val < p.val && root.val < q.val){
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode(3, new TreeNode(5), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.right; // Node with value 1
        TreeNode lca = lowestCommonAncestor.lowestCommonAncestor2(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val); // Output: 3
    }
}
