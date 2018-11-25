package com.leetcode.easy;

import org.junit.Test;

public class ReverseIntegerSolution {

    @Test
    public void test(){
        System.out.println(reverse(123));
    }
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            if(ans>Integer.MAX_VALUE/10 || ans<Integer.MIN_VALUE/10) return 0;
            ans*=10;
            if(ans>Integer.MAX_VALUE-x%10 || ans<Integer.MIN_VALUE-x%10) return 0;
            ans+=x%10;
            x=x/10;
        }
        return ans;
    }
}
