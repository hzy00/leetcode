package com.leetcode.medium;

import org.junit.Test;

public class PalindrmicSubStrSolution {

    @Test
    public void test(){
        countSubstrings("abc");
    }

    public int countSubstrings(String s) {
        if(s == null || s.length() < 1) return 0;
        int center = 0,right = 0;
        char[] t = new char[s.length()*2+1];
        t[0] = '#';
        for(int i =0;i<s.length();i++){
            t[2*i+1] = s.charAt(i);
            t[2*i+2] = '#';
        }
        int[] z = new  int[t.length];
        for(int i=1;i<z.length-1;i++){
            if(i<right){
                z[i] =  Math.min(right-i,z[2*center-i]);
            }
            while(i-z[i]-1>=0 && i+z[i]+1<t.length && t[i-z[i]-1] == t[i+z[i]+1]) z[i]++;
            if(i+z[i]>right){
                center = i;
                right = i+z[i];
            }
        }
        int ans = 0;
        for(int num:z){
            ans+=num;
        }
        return ans;
    }
}
