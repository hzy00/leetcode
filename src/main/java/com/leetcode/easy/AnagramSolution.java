package com.leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramSolution {

    @Test
    public void test(){
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null || s.length()<p.length()) return new ArrayList<>();
        int[] arr = new int[26];
        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        retry:
        for(int i=0;i<=s.length()-p.length();i++){
            int[] tmp = Arrays.copyOf(arr,arr.length);
            for(int j=i;j<p.length();j++){
                int index = s.charAt(j)-'a';
                if(arr[index] == 0){
                    i=j;
                    continue retry;
                }
                if(tmp[index] == 0){
                    continue retry;
                }
                tmp[index]--;
            }
            ans.add(i);
        }
        return ans;
    }
}
