package com.leetcode.easy;

import org.junit.Test;

/**
 * Created by hzy on 18/8/31.
 */
public class NthSolution {

    @Test
    public void test(){
        System.out.println(findNthDigit(2147483647));
        StringBuilder sb = new StringBuilder(Long.toBinaryString(  4294967295l));
        System.out.println((int) Long.parseLong(sb.reverse().toString(), 2));
    }

    public int findNthDigit(int n) {
        int len = 1;
        int start = 1;
        long count = 9;
        while(n > len*count){
            n-=len*count;
            start*=10;
            count*=10;
            len++;
        }
        count = (n-1)%len;
        len = (n-1)/len;
        return String.valueOf(start+len).charAt((int)count) - '0';
    }
}
