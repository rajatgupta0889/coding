package com.learn.dsa.trees;

public class KthSmallestInBST {

    /*
     * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     * 230. Kth Smallest Element in a BST
     * */
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode result =   inorderTraversal(root, k);
        return result != null ? result.val : 0;
    }

    public TreeNode inorderTraversal(TreeNode root, int k){
        if(root == null) return null;
        TreeNode left = inorderTraversal(root.left, k);
        if(left != null) return left;
        count++;
        if(count == k) return root;
        TreeNode right = inorderTraversal(root.right, k);
        return right;

    }

    public static void main(String[] args) {
        KthSmallestInBST kthSmallestInBST = new KthSmallestInBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        System.out.println(kthSmallestInBST.kthSmallest(root, 1)); // 1
        System.out.println(kthSmallestInBST.kthSmallest(root, 2)); // 2
        System.out.println(kthSmallestInBST.kthSmallest(root, 3)); // 3
        System.out.println(kthSmallestInBST.kthSmallest(root, 4)); // 4
    }

}
