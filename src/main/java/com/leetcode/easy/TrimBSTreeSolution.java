package com.leetcode.easy;

import com.leetcode.TreeNode;

/**
 * Created by 75623 on 2018/5/15.
 */
public class TrimBSTreeSolution {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return root;
        }
        if(root.val<L){
            return trimBST(root.right,L,R);
        }else if(root.val>R){
            return trimBST(root.left,L,R);
        }else{
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
            return root;
        }
    }
}
