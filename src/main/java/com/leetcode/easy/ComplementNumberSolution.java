package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 75623 on 2018/5/10.
 */
public class ComplementNumberSolution {

    @Test
    public void test(){
        Assert.assertEquals(-2,findComplement(-5));
    }

    public int findComplement(int num) {
        if(num == 0){
            return 0;
        }
        int m = num<0?-1:1;
        int result = 0;
        num = Math.abs(num);
        int index = 0;
        while(num>0){
            int tmp = num%2;
            result+= (1-tmp)*Math.pow(2,index);
            index++;
            num/=2;
        }
        return m*result;
    }
}
