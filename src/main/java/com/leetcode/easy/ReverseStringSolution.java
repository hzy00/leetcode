package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75623 on 2018/5/11.
 */
public class ReverseStringSolution {

    /**
     *
     * @param s
     * @return
     */
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

    /**
     * 带空格的string
     * @param s
     * @return
     */
    public String reverseString2(String s) {
        if(s == null || s.length()<=1){
            return s;
        }
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ss.length;i++){
            sb.append(reverseString(ss[i])).append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }
}
