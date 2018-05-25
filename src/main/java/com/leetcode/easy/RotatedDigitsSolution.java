package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hzy on 18/5/25.
 */
public class RotatedDigitsSolution {

    @Test
    public void test(){
        Assert.assertEquals(4,rotatedDigits(10));
    }

    public int rotatedDigits(int N) {
        int sum = 0;
        for(int i=1;i<=N;i++){
            final String str = String.valueOf(i);
            if(str.contains("3") || str.contains("4") || str.contains("7")){
                continue;
            }
            if(str.contains("2") || str.contains("5") || str.contains("6") || str.contains("9")){
                sum++;
            }
        }
        return sum;
    }



}
