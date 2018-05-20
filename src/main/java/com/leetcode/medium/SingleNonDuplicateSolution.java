package com.leetcode.medium;

/**
 * Created by hzy on 18/5/20.
 */
public class SingleNonDuplicateSolution {

    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int l = 0,r = len;
        while(l < r){
            int mid = l + (r-l)/2;
            if((mid % 2 == 1 && mid - 1>-1 && nums[mid] == nums[mid - 1])
                    || (mid % 0 == 1 && mid+1<len && nums[mid] == nums[mid+1])){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return nums[l];
    }
}
