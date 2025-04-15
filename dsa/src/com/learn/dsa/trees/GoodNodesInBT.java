package com.learn.dsa.trees;

public class GoodNodesInBT {

    /**
     * https://leetcode.com/problems/maximum-good-people-in-a-tree/
     * 1448. Count Good Nodes in Binary Tree
     * */
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxVal) {
            if(root == null)
                return 0;

            int res = root.val >= maxVal ? 1 : 0;
            maxVal = Math.max(maxVal, root.val);
            res += dfs(root.left, maxVal);
            res += dfs(root.right, maxVal);
            return res;
    }

    public static void main(String[] args) {
        GoodNodesInBT goodNodesInBT = new GoodNodesInBT();
        TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(2), new TreeNode(5)));
        int goodNodesCount = goodNodesInBT.goodNodes(root);
        System.out.println("Good Nodes Count: " + goodNodesCount); // Output: 4
    }
}
