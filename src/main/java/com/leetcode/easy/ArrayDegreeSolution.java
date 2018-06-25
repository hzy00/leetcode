package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzy on 18/6/22.
 */
public class ArrayDegreeSolution {

    @Test
    public void test(){
        Assert.assertEquals(7,findShortestSubArray(new int[]{2,1,1,2,1,3,3,3,1,3,1,3,2}));
    }

    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer,Integer> times = new HashMap<>();
        Map<Integer,Integer> start = new HashMap<>();
        Map<Integer,Integer> end = new HashMap<>();
        int maxTime = 0,tmp;
        for(int i=0;i<nums.length;i++){
            if(start.containsKey(nums[i])){
                end.put(nums[i],i);
            }else{
                end.put(nums[i],i);
                start.put(nums[i],i);
            }
            if(times.containsKey(nums[i])){
                tmp = times.get(nums[i])+1;
            }else{
                tmp = 1;
            }
            times.put(nums[i],tmp);
            if(tmp > maxTime){
                maxTime = tmp;
            }
        }
        int res = nums.length;
        for(int k:times.keySet()){
            if(times.get(k) == maxTime){
                res = Math.min(res,end.get(k) - start.get(k) + 1);
            }
        }

        return res;
    }
}
