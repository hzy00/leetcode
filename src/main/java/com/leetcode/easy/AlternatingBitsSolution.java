package com.leetcode.easy;

/**
 * Created by hzy on 18/5/18.
 * 位运算 n>>1 & n = 0
 */
public class AlternatingBitsSolution {

    public boolean hasAlternatingBits(int n) {
        if(n == 0){
            return true;
        }
        n = Math.abs(n);
        int i = -1;
        while(n>0){
            if(i == n%2){
                return false;
            }
            i = n%2;
            n/=2;
        }
        return true;
    }
}
