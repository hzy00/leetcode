package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 75623 on 2018/5/7.
 */
public class ArrayPartition1Solution {

    @Test
    public void test(){
        Assert.assertEquals(3,arrayPairSum(new int[]{1,2,3,2}));
        Assert.assertEquals(9,arrayPairSum(new int[]{4,2,5,5,6,0}));
    }


    public int arrayPairSum(int[] nums) {
        quickSort(nums,0,nums.length-1);
        int sum = 0;
        for(int i=0;i<nums.length;i+=2){
            sum+=nums[i];
        }
        return sum;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        if (end - start == 1) {
            swap(nums, start, end);
            return;
        }

        int idx = end, i = start, j = end - 1, idxVal = nums[end];
        while (i < j) {
            for (; i <= j; i++) {
                if (nums[i] > idxVal) {
                    nums[idx] = nums[i];
                    idx = i;
                    break;
                }
            }
            for (; j >= i; j--) {
                if (nums[j] < idxVal) {
                    nums[idx] = nums[j];
                    idx = j;
                    break;
                }
            }
        }
        nums[idx] = idxVal;
        if(idx+1<end) {
            quickSort(nums, idx + 1, end);
        }
        if(idx-1>start){
            quickSort(nums,start,idx-1);
        }
    }

    private void swap(int[] nums, int start, int end) {
        if (nums[start] > nums[end]) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }

}
