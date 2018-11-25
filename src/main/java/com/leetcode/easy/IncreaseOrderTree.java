package com.leetcode.easy;

import com.leetcode.TreeNode;
import org.junit.Test;

public class IncreaseOrderTree {

    TreeNode minNode = null;
    TreeNode tmp = null;

    @Test
    public void test(){
        TreeNode node = new TreeNode(888);
        node.left = new TreeNode(378);
        System.out.println(increasingBST(node).val);
    }
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return root;
        minNode = null;
        tmp = null;
        dfs(root);
        return minNode;
    }

    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(minNode == null) minNode = root;
        if(tmp != null){
            root.left = null;
            tmp.right = root;
        }
        tmp = root;
        dfs(root.right);
    }
}
