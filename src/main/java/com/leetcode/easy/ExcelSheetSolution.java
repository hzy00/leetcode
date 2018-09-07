package com.leetcode.easy;

import org.junit.Test;

/**
 * Created by hzy on 18/9/1.
 */
public class ExcelSheetSolution {

    @Test
    public void test(){

    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        parseChar(n,sb);
        return sb.toString();
    }

    private void parseChar(int n,StringBuilder sb){

        int t = n-1;
        int len = 0;
        while(t>26){
            t/=26;
            len++;
        }
        sb.append((char)(t-1+'A'));
        if(t == n-1) return;
        n-=t*Math.pow(26,len);
        if(n>0) parseChar(n,sb);
    }
}
