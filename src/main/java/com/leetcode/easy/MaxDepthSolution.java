package com.leetcode.easy;

import com.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by hzy on 18/5/20.
 */
public class MaxDepthSolution {

    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        //bfs
        Queue<TreeNode> treeNodes = new ArrayDeque<TreeNode>();
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            final int size = treeNodes.size();
            for(int i=0;i<size;i++){
                TreeNode treeNode = treeNodes.poll();
                if(treeNode.left != null){
                    treeNodes.add(treeNode.left);
                }
                if(treeNode.right != null){
                    treeNodes.add(treeNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public void dfs(TreeNode treeNode,int depth){
        if(treeNode == null){
            return;
        }
        if(this.depth < depth){
            this.depth = depth;
        }
        dfs(treeNode.left,depth+1);
        dfs(treeNode.right,depth+1);
    }
}
