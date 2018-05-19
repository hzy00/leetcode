package com.leetcode.easy;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzy on 18/5/18.
 * 求树的每一层平均值，bfs广度优先算法
 */
public class LevelAverageSolution {

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return null;
        }
//        List<Double> averageList = new ArrayList<Double>();
//        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
//        treeNodes.add(root);
//        bfs(treeNodes,averageList);
//        return averageList;

        List<Double> sum = new ArrayList<Double>();
        List<Integer> count = new ArrayList<Integer>();
        dfs(root,0,sum,count);
        for(int i=0;i<sum.size();i++){
            sum.set(i,sum.get(i)/count.get(i));
        }
        return sum;
    }

    public void bfs(List<TreeNode> treeNodes,List<Double> average){
        if(treeNodes == null || treeNodes.size()<1){
            return;
        }

        double sum = 0;
        List<TreeNode> tmp = new ArrayList<TreeNode>();
        for(TreeNode treeNode:treeNodes){
            sum += treeNode.val;
            if(treeNode.left != null){
                tmp.add(treeNode.left);
            }
            if(treeNode.right != null){
                tmp.add(treeNode.right);
            }
        }
        average.add(sum/treeNodes.size());
        bfs(tmp,average);
    }

    public void dfs(TreeNode treeNode,int level,List<Double> sum,List<Integer> count){
        if(treeNode != null){
            if(level+1>sum.size()){
                sum.add((double)treeNode.val);
                count.add(1);
            }else {
                sum.set(level, sum.get(level) + treeNode.val);
                count.set(level,count.get(level) + 1);
            }
            dfs(treeNode.left,level+1,sum,count);
            dfs(treeNode.right,level+1,sum,count);
        }
    }
}
