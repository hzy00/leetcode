package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * Created by hzy on 18/5/20.
 */
public class InvertTreeSolution {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
