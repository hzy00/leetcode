package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzy on 18/5/24.
 */
public class FindDisappearNumberSolution {


    @Test
    public void test(){
        Assert.assertEquals(8l,(long)findDisappearedNumbers(new int[]{10,2,5,10,9,1,1,4,3,7}).get(1));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null){
            return null;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}
