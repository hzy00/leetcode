package com.leetcode.easy;

import org.junit.Test;

/**
 * Created by hzy on 18/8/31.
 */
public class ShortestSubArrSolution {

    @Test
    public void test(){
        System.out.println(findUnsortedSubarray(new int[]{1,3,2,2,2,2}));
    }

    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int l=0,r=nums.length-1;
        while(l<nums.length-1){
            if(nums[l]<=nums[l+1]){
                l++;
            }else{
                break;
            }
        }
        if(l == nums.length-1) return 0;
        while(r>0){
            if(nums[r]>=nums[r-1]){
                r--;
            }else{
                break;
            }
        }
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=l;i<=r;i++){
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
        for(int i=0;i<=l;i++){
            if(nums[i] > min){
                l = i;
                break;
            }
        }
        for(int i=nums.length-1;i>=r;i--){
            if(nums[i] < min){
                r = i;
                break;
            }
        }
        return r-l+1;
    }
}
