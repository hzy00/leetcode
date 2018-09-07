package com.leetcode.easy;

import org.junit.Test;

/**
 * Created by hzy on 18/8/29.
 */
public class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if(sums == null) return 0;
        i=(i<0)?0:i;
        j=(j>=sums.length)?sums.length-1:j;
        if(i<=0){
            return sums[j];
        }else{
            return sums[j] - sums[i-1];
        }
    }

}
