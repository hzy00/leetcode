package com.leetcode.medium;

/**
 * Created by 75623 on 2018/5/8.
 */
public class PruneTreeSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root)?root:null;
    }

    private boolean containsOne(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        boolean l = containsOne(treeNode.left);
        boolean r = containsOne(treeNode.right);
        if (!l) {
            treeNode.left = null;
        }
        if (!r) {
            treeNode.right = null;
        }
        return treeNode.val == 1 || l || r;
    }
}
