package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.Arrays;

/**
 * Created by 75623 on 2018/5/9.
 */
public class MaximumBinaryTreeSolution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums,int start,int end) {
        if(nums == null
                || nums.length < 1
                || start == end){
            return null;
        }
        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }
        int maxIdx = maxIdx(nums,start,end);
        TreeNode treeNode = new TreeNode(nums[maxIdx]);
        if(maxIdx > 0) {
            treeNode.left = constructMaximumBinaryTree(nums,start,maxIdx);
        }
        if(maxIdx < nums.length-1){
            treeNode.right = constructMaximumBinaryTree(nums,maxIdx+1,end);
        }
        return treeNode;
    }

    public int maxIdx(int[]nums, int start,int end){
        int maxIdx = start;
        for(int i=start+1;i<end;i++){
            if(nums[i]>nums[maxIdx]){
                maxIdx = i;
            }
        }
        return maxIdx;
    }


}
