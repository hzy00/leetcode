package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 75623 on 2018/5/6.
 */
public class JewelsSolution {

    @Test
    public void test(){
        Assert.assertEquals(sumOfJewels(null,"sss"),0);
        Assert.assertEquals(sumOfJewels("dads",""),0);
        Assert.assertEquals(sumOfJewels("a","bbbsddfs"),0);
        Assert.assertEquals(sumOfJewels("a","abbbsddfs"),1);
        Assert.assertEquals(sumOfJewels("abb","abbbbdsdsds"),5);
    }

    public  int sumOfJewels(String J,String S){
        if(S == null
                || S.length() < 1
                || J == null
                || J.length() < 1){
            return 0;
        }

        int sum = 0;
        for(int i=0;i<S.length();i++){
            if(J.indexOf(S.charAt(i))>-1){
                sum++;
            }
        }
        return sum;
    }
}
