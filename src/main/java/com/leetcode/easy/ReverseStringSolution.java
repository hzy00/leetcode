package com.leetcode.easy;

/**
 * Created by 75623 on 2018/5/11.
 */
public class ReverseStringSolution {

    public String reverseString(String s) {
        if(s == null || s.length()<=1){
            return s;
        }
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length()/2;i++){
            char tmp = chars[i];
            chars[i] = chars[s.length()-i-1];
            chars[s.length()-i-1] = tmp;
        }
        return new String(chars);
    }
}
