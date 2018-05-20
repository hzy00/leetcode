package com.leetcode.medium;

/**
 * Created by hzy on 18/5/20.
 */
public class OptionalDivisionSolution {
    public String optimalDivision(int[] nums) {
        if(nums == null){
            return "0";
        }
        if(nums.length == 1){
            return String.valueOf(nums[0]);
        }
        StringBuilder str = new StringBuilder().append(nums[0]).append("/");
        int len = nums.length;
        if(len > 2){
            str.append("(");
        }
        for(int i=1;i<len;i++){
            str.append(nums[i]).append("/");
        }
        str.setLength(str.length()-1);
        if(len > 2){
            str.append(")");
        }
        return str.toString();
    }
}
