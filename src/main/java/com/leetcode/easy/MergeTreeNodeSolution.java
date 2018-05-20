package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * Created by 75623 on 2018/5/7.
 */
public class MergeTreeNodeSolution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return mergeTreeNode(t1,t2);
    }

    public TreeNode mergeTreeNode(TreeNode t1,TreeNode t2){
        TreeNode treeNode = t1;
        if(treeNode == null){
            return t2;
        }
        if(t2 != null){
            treeNode.val+=t2.val;
            treeNode.left = mergeTreeNode(treeNode.left,t2.left);
            treeNode.right = mergeTreeNode(treeNode.right,t2.right);
        }
        return treeNode;
    }
}
