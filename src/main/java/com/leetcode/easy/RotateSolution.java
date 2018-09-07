package com.leetcode.easy;

import org.junit.Test;

/**
 * Created by hzy on 18/9/1.
 */
public class RotateSolution {


    @Test
    public void test(){
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length<2) return;
        while(k>=nums.length){
            k-=nums.length;
        }
        if(k<1) return;
        int cur;
        int i=0,li=0;
        int pre = nums[i];
        int sum = 0;
        while(true){
            sum++;
            if(sum>nums.length) break;
            i+=k;
            if(i>=nums.length){
                i-=nums.length;
            }
            if(i==li){
                nums[i] = pre;
                i++;
                pre = nums[i];
                li=i;
                continue;
            }

            cur = nums[i];
            nums[i] = pre;
            pre = cur;

        }
    }
}
