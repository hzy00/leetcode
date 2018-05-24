package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hzy on 18/5/22.
 */
public class MaxIslandAreaSolution {

    @Test
    public void test(){
        System.out.println('1'+0);
        System.out.println("1".codePointAt(0));
        System.out.println('9'+0);
        System.out.println('a'+0);
        System.out.println('A'+0);
        System.out.println('Z'+0);
        Assert.assertEquals(4,maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                max = Math.max(max, maxAreaOfIsland(grid,i,j));
            }
        }
        return max;
    }

    public int maxAreaOfIsland(int[][] grid,int i,int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = -1;
        return 1 + maxAreaOfIsland(grid,i-1,j) + maxAreaOfIsland(grid,i+1,j) + maxAreaOfIsland(grid,i,j+1) + maxAreaOfIsland(grid,i,j-1);
    }

}
