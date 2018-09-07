package com.leetcode.easy;

import org.junit.Test;

/**
 * Created by hzy on 18/8/13.
 */
public class FindErrorNumSolution {

    @Test
    public void test(){
        findErrorNums(new int[]{64,53,18,11,1,46,31,7,25,23,8,44,49,35,3,25,57,39,61,54,40,58,70,2,47,12,66,59,26,30,52,20,21,63,43,34,67,28,24,5,69,55,50,22,27,29,48,10,42,36,60,68,32,4,16,65,13,15,62,6,45,17,37,33,14,38,41,9,51,19});
    }

    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int tmp = 0;
        for(int num:nums){
            if(num == 0){
                nums[tmp - 1] = -nums[tmp-1];
                continue;
            }
            if(nums[Math.abs(num)-1] < 0){
                tmp = -nums[Math.abs(num)-1];
                nums[Math.abs(num)-1] = 0;
            }
            else nums[Math.abs(num)-1] = -nums[Math.abs(num)-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                ans[1] = i+1;
                if(ans[0] != 0){
                    break;
                }
            }else if(nums[i] == 0){
                ans[0] = i+1;
                if(ans[1] != 0){
                    break;
                }
            }
        }
        return ans;
    }
}
