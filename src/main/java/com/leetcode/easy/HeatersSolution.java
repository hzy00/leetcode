package com.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by hzy on 18/8/31.
 */
public class HeatersSolution {


    @Test
    public void test(){
        System.out.println(findRadius(new int[]{1,2,3,4},new int[]{1,4}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = 0;
        for(int house:houses){
            int index = Arrays.binarySearch(heaters,house);
            if(index < 0){
                index = -(index+1);
            }
            int t;
            if(index == 0){
                t = heaters[0] - house;
            }else if(index < heaters.length-1){
                t = Math.min(house-heaters[index],heaters[index+1]-house);
            }else{
                t = house - heaters[heaters.length-1];
            }
            max = Math.max(max,t);
        }
        return max;
    }
}
