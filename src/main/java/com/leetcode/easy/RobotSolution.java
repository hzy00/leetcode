package com.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

public class RobotSolution {

    @Test
    public void test(){
        char a = 1+'A';
        System.out.println(a);
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] p = new int[]{0,0};
        int idx=1,i=1;
        for(int num:commands){
            if(num<0){
                i=parseStep(idx,i,num);
                idx = 1-idx;
            }else robotWalk(p,idx,i,num,obstacles);
        }
        return p[0]*p[0]+p[1]*p[1];
    }

    private int parseStep(int idx,int i,int command){
        if(command == -1){
            if(idx == 1) return i;
            else return -i;
        }else{
            if(idx == 1) return -i;
            else return i;
        }
    }

    public void robotWalk(int[] p,int idx,int i,int step,int[][]obstacles){
        while(step>0){
            step--;
            p[idx]+=i;
            for(int[] arr:obstacles){
                if(Arrays.equals(p,arr)){
                    p[idx]-=i;
                    return;
                }
            }
        }
    }
}
