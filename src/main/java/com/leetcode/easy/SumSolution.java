package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hzy on 18/5/28.
 */
public class SumSolution {

    @Test
    public void test(){
        Assert.assertEquals(5,getSum(2,3));
    }

    public int getSum(int a, int b) {
        int c=b;
        while(a != 0){
            c = a^b;
            a = (a&b)<<1;
            b = c;
        }
        return c;
    }
}
