package com.leetcode.easy;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by hzy on 18/6/22.
 */
public class BoomerangsSolution {


    @Test
    public void test(){
        Assert.assertEquals(2, numberOfBoomerangs(new int[][]{new int[]{0, 0}, new int[]{1,0},new int[]{2,0}}));
    }

    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length < 3){
            return 0;
        }
        int res = 0;
        Map<Integer,Integer> tmp = new HashMap<Integer,Integer>();
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(j == i) continue;
                int d = (int)(Math.pow(points[j][0]-points[i][0],2)+Math.pow(points[j][1]-points[i][1],2));
                if(tmp.containsKey(d)){
                    tmp.put(d,tmp.get(d)+1);
                }else{
                    tmp.put(d,1);
                }
            }
            for(int val:tmp.values()){
                res+=val*(val-1);
            }
            tmp.clear();
            Queue queue = new ArrayDeque();
        }
        return res;
    }
}
