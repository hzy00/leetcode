package com.leetcode.easy;

/**
 * Created by hzy on 18/6/12.
 */
public class RectangularSolution {

    public int[] constructRectangle(int area) {
        if(area <= 0){
            return null;
        }
        int sqrt = (int)Math.ceil(Math.sqrt(area));
        if(area%sqrt == 0){
            return new int[]{sqrt,area/sqrt};
        }
        for(int i=sqrt+1;i<=area;i++){
            if(area%i == 0){
                return new int[]{i,area/i};
            }
        }
        return new int[]{area,1};
    }
}
