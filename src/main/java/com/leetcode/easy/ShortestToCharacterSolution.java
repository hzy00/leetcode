package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 75623 on 2018/5/9.
 */
public class ShortestToCharacterSolution {

    @Test()
    public void test(){
        Assert.assertEquals(3,shortestToChar("loveleetcode",'e')[0]);
    }

    public int[] shortestToChar1(String S, char C) {
        if(S == null || S.length()<1){
            return null;
        }
        int[] distances = new int[S.length()];
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == C){
                distances[i] = 0;
            }else{
                int r = Math.abs(S.indexOf(C,i+1) - i);
                int l =  S.substring(0,i).lastIndexOf(C);
                if(l > -1){
                    distances[i] = Math.min(r,i-l);
                }else{
                    distances[i] = r;
                }

            }
        }
        return distances;
    }

    public int[] shortestToChar(String S, char C) {
        if(S == null || S.length()<1){
            return null;
        }
        int[] distances = new int[S.length()];
        int pre = Integer.MAX_VALUE/2;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == C)pre = i;
            distances[i] = i-pre;
        }
        for(int i=S.length()-1;i>-1;i--){
            if(S.charAt(i) == C)pre = i;
            distances[i] = Math.min(Math.abs(i-pre),Math.abs(distances[i]));
        }
        return distances;
    }
}
