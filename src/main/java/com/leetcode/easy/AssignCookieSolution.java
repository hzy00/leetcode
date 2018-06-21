package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by hzy on 18/6/21.
 */
public class AssignCookieSolution {

    @Test
    public void test(){
        Assert.assertEquals(1, findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        Assert.assertEquals(2, findContentChildren(new int[]{1, 1}, new int[]{1, 2, 3, 4}));
        Assert.assertEquals(1, findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
        Assert.assertEquals(0, findContentChildren(new int[]{1, 2, 3}, new int[]{0}));
    }

    public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length < 1 || s == null || s.length < 1){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        if(s[s.length-1]<g[0]){
            return 0;
        }
        int i=0,j=0,res=0;
        for(;j<s.length && i<g.length;i++){
            for(;j<s.length;j++){
                if(s[j] >= g[i]){
                    j++;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
