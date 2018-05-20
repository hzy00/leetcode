package com.leetcode.medium;

import com.leetcode.TreeNode;

/**
 * Created by 75623 on 2018/5/8.
 * 递归判断节点是否该删除
 */
public class PruneTreeSolution {

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
