package com.leetcode.easy;

import com.leetcode.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzy on 18/5/30.
 */
public class TwoSumSolution {

//    public boolean findTarget(TreeNode root, int k) {
//
//    }

    @Test
    public void test(){
        isAnagram("anagram","nagaram");
    }

    public boolean isAnagram(String s, String t) {
        if(s == null || s.length() < 1
                || t == null || t.length() < 1
                || s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> timesMap = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(timesMap.containsKey(s.charAt(i))){
                timesMap.put(s.charAt(i),timesMap.get(s.charAt(i))+1);
            }else{
                timesMap.put(s.charAt(i),1);
            }
        }

        for(int i=0;i<t.length();i++){
            if(timesMap.containsKey(t.charAt(i))){
                int times = timesMap.get(t.charAt(i));
                times--;
                if(times == 0){
                    timesMap.remove(t.charAt(i));
                }else{
                    timesMap.put(t.charAt(i),times);
                }
            }else{
                return false;
            }
        }
        return timesMap.isEmpty();
    }
}
