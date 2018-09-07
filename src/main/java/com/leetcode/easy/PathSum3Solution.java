package com.leetcode.easy;

import com.leetcode.TreeNode;
import org.junit.Test;

import java.util.Map;

/**
 * Created by hzy on 18/8/10.
 */
public class PathSum3Solution {


    public int helper(TreeNode root,int target,int sum,Map<Integer,Integer> map){
        if(root == null) return 0;
        sum+=root.val;
        int result = 0;
        if(map.containsKey(target-sum)){
            result = map.get(target-sum);
        }
        if(map.containsKey(sum)){
            map.put(sum,map.get(sum)+1);
        }else{
            map.put(sum,1);
        }
        result+=helper(root.left,target,sum,map)+helper(root.right,target,sum,map);
        return result;
    }

    @Test
    public void test(){
        NumArray na = new NumArray(new int[]{-2,0,3,-5,2,-1});
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));

    }
}
