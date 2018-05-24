package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hzy on 18/5/23.
 */
public class CapitalWordSolution {

    @Test
    public void test(){
        Assert.assertTrue(detectCapitalUse("ggg"));
        Assert.assertTrue(detectCapitalUse("Leetcode"));
        Assert.assertTrue(detectCapitalUse("CHINA"));
        Assert.assertTrue(!detectCapitalUse("gHdd"));
    }

    public boolean detectCapitalUse(String word) {
        if(word == null){
            return false;
        }
        if(word.length()<=1){
            return true;
        }
        boolean upFlag = word.charAt(1)<'a';
        boolean firstFlag = word.charAt(0)<'a';
        if(upFlag && !firstFlag){
            return false;
        }

        for(int i=2;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch < 'a'){
                if(!upFlag){
                    return false;
                }
            }else if(upFlag){
                return false;
            }
        }
        return true;
    }
}
