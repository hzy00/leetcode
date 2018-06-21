package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hzy on 18/6/21.
 */
public class BackSpaceCompareSolution {

    @Test
    public void test(){
        Assert.assertTrue(!backspaceCompare("asd#a","asda"));
    }

    public boolean backspaceCompare(String S, String T) {
        if(S.equals(T)){
            return true;
        }
        int i=S.length()-1,j=T.length()-1;
        while(i>=0 || j>=0){
            int sum = 0;
            while(i>=0){
                if(S.charAt(i) == '#'){
                    sum++;
                    i--;
                }else if(sum > 0){
                    sum--;
                    i--;
                }else{
                    break;
                }
            }
            while(j>=0){
                if(T.charAt(j) == '#'){
                    sum++;
                    j--;
                }else if(sum > 0){
                    sum--;
                    j--;
                }else{
                    break;
                }
            }
            if((i<0 && j<0) || (j >= 0 && i >= 0 && S.charAt(i) == T.charAt(j))){
                i--;
                j--;
                continue;
            }else{
                return false;
            }
        }
        return i < 0 && j < 0;
    }
}
