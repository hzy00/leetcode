package com.leetcode.medium;

/**
 * Created by 75623 on 2018/5/6.
 */
public class SkyLineSolution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid == null
                || grid.length == 0
                || grid[0] == null
                || grid[0].length == 0){
            return 0;
        }

        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for(int i = 0;i < grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] > colMax[j]){
                    colMax[j] = grid[i][j];
                }
                if(grid[i][j]>rowMax[i]){
                    rowMax[i] = grid[i][j];
                }
            }
        }

        int result = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                result += min(rowMax[i],colMax[j]) - grid[i][j];
            }
        }
        return result;
    }

    private int min(int a,int b){
        return a<b?a:b;
    }
}
