package com.leetcode.easy;

/**
 * Created by hzy on 18/5/24.
 */
public class FindDifferenceSolution {

    public char findTheDifference(String s, String t) {
        if(t == null || t.length()<1){
            return ' ';
        }
        if(s == null || s.length()<1){
            return t.charAt(0);
        }
        char ch = s.charAt(0);
        for(int i=1;i<s.length();i++){
            ch ^= s.charAt(i);
        }
        for(int i=0;i<t.length();i++){
            ch ^= t.charAt(i);
        }
        return ch;
    }
}
