package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzy on 18/5/17.
 */
public class BottomLeftSolution {

    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
//        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
//        treeNodes.add(root);
//        treeNodes = bfs(treeNodes);
//        return treeNodes.get(treeNodes.size()-1).val;
        int[] res = new int[]{0,0};
        dfs(root,1,res);
        return res[1];
    }

    public List<TreeNode> bfs(List<TreeNode> treeNodes){
        if(treeNodes == null
                || treeNodes.size()<1){
            return null;
        }
        List<TreeNode> tmp = new ArrayList<TreeNode>();
        for(TreeNode treeNode:treeNodes){
            if(treeNode.right != null){
                tmp.add(treeNode.right);
            }
            if(treeNode.left != null){
                tmp.add(treeNode.left);
            }
        }
        if(tmp.size() == 0){
            return treeNodes;
        }else{
            return bfs(tmp);
        }
    }

    public void dfs(TreeNode treeNode,int deep,int[] res){
        if(res[0]<deep){
            res[0] = deep;
            res[1] = treeNode.val;
        }
        deep++;
        if(treeNode.right != null) {
            dfs(treeNode.right, deep, res);
        }
        if(treeNode.left != null){
            dfs(treeNode.left,deep,res);
        }

    }
}
