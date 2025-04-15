package com.learn.dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    /**
     * https://leetcode.com/problems/binary-tree-right-side-view/
     * 199. Binary Tree Right Side View
     * */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewHelper(root, 0, result);
        return result;
    }

    private void rightSideViewHelper(TreeNode root, int i, List<Integer> result) {
        if(root == null) {
            return;
        }

        if(i == result.size()) {
            result.add(root.val);
        }

        rightSideViewHelper(root.right, i + 1, result);
        rightSideViewHelper(root.left, i + 1, result);
    }

    public static void main(String[] args) {
        RightSideView rightSideView = new RightSideView();
        TreeNode root = new TreeNode(1, null, new TreeNode(3));
        List<Integer> rightView = rightSideView.rightSideView(root);
        System.out.println("Right Side View: " + rightView); // Output: [1, 3]
    }
}
