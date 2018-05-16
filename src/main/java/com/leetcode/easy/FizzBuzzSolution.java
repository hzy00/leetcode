package com.leetcode.easy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 75623 on 2018/5/16.
 */
public class FizzBuzzSolution {

    public List<String> fizzBuzz(int n) {
        if(n<=0){
            return null;
        }
        String[] strs = new String[n];
        for(int i=3;i<=n;i+=3){
            strs[i-1] = "Fizz";
        }
        for(int i=5;i<=n;i+=5){
            if(strs[i-1] != null) {
                strs[i-1] += "Buzz";
            }else{
                strs[i-1] = "Buzz";
            }
        }
        for(int i=1;i<=n;i+=2){
            if(strs[i-1] == null){
                strs[i-1] = String.valueOf(i);
            }
        }
        for(int i=2;i<=n;i+=2){
            if(strs[i-1] == null){
                strs[i-1] = String.valueOf(i);
            }
        }
        return Arrays.asList(strs);
    }
}
