package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75623 on 2018/5/7.
 */
public class SelfDividingNumberSolution {

    @Test
    public void test(){
        Assert.assertEquals(13,selfDividingNumbers(1,22).size());
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = left;i<=right;i++){
            int tmp = i;
            while(tmp > 0){
                if(tmp%10 != 0 && i%(tmp%10) == 0){
                    tmp = tmp/10;
                }else{
                    break;
                }
            }
            if(tmp == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
