package com.leetcode.easy;

/**
 * Created by 75623 on 2018/5/17.
 */
public class MatrixReshapeSolution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length < 1 || r * c != nums.length * nums[0].length) {
            return nums;
        }
        int[][] res = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res[i][j] = nums[(i*c+j)/nums[0].length][(i*c+j)%nums[0].length-1];
            }
        }
        return res;
    }
}
