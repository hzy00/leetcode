package com.leetcode.easy;

/**
 * Created by 75623 on 2018/5/16.
 */
public class LandPerimeterSolution {

    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length<1){
            return 0;
        }
        int result = 0;
        for(int i=0;i<grid.length;i++){
            if(grid[i] == null){
                continue;
            }
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    result+=4;
                    if(i-1>-1 && grid[i-1][j] == 1){
                        result--;
                    }
                    if(i+1<grid.length && grid[i+1][j] == 1){
                        result--;
                    }
                    if(j-1>-1 && grid[i][j-1] == 1){
                        result--;
                    }
                    if(j+1<grid[i].length && grid[i][j+1] == 1){
                        result--;
                    }
                }
            }
        }
        return result;
    }
}
