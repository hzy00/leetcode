package com.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 75623 on 2018/5/17.
 */
public class NextGreaterNumberSolution {

    @Test
    public void test(){
        nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < nums1.length) {
            return nums1;
        }
        boolean flag = false;
        for(int i=0;i<nums1.length;i++){
            for(int j = 0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    flag = true;
                }else if(nums2[j]>nums1[i] && flag){
                    nums1[i] = nums2[j];
                    break;
                }
                if(j == nums2.length-1){
                    nums1[i] = -1;
                }
            }
            flag = false;
        }
        return nums1;
    }
}
