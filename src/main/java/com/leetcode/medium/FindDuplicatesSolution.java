package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75623 on 2018/5/15.
 */
public class FindDuplicatesSolution {

    /**
     * 因为1<=nums[i]<=n，正好是数组下标的取值+1，当某个值出现两次，意味着这个下标会被访问到两次
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        if(nums == null){
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]<0){
                result.add(idx+1);
            }
            nums[idx] = -nums[idx];
        }
        return result;
    }
}
