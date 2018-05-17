package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 75623 on 2018/5/15.
 */
public class CustomSortSolution {

    public String customSortString(String S, String T) {
        if (S == null || S.length() < 1
                || T == null || T.length() < 1) {
            return T;
        }

        Map<Character,Integer> record = new HashMap<Character, Integer>();
        for(char ch:T.toCharArray()){
            if(record.containsKey(ch)){
                record.put(ch,record.get(ch)+1);
            }else{
                record.put(ch,1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:S.toCharArray()){
            if(record.containsKey(ch)){
                for(int i=0;i<record.get(ch);i++) {
                    sb.append(ch);
                }
                record.remove(ch);
            }
        }
        for(Character ch:record.keySet()){
            for(int i=0;i<record.get(ch);i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
