package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hzy on 18/5/18.
 */
public class GoatLatinSolution {

    @Test
    public void test(){
        Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa",toGoatLatin("I speak Goat Latin"));
    }

    public String toGoatLatin(String S) {
        if(S == null || S.length() <1){
            return S;
        }
        StringBuilder res = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        for(String word:S.split("\\s")){
            suffix.append("a");
            if(word.charAt(0) == 'a'
                    || word.charAt(0) == 'A'
                    || word.charAt(0) == 'e'
                    || word.charAt(0) == 'E'
                    || word.charAt(0) == 'u'
                    || word.charAt(0) == 'U'
                    || word.charAt(0) == 'o'
                    || word.charAt(0) == 'O'
                    || word.charAt(0) == 'i'
                    || word.charAt(0) == 'I'){
                res.append(word).append("ma");
            }else{
                res.append(word.substring(1)).append(word.charAt(0)).append("ma");
            }
            res.append(suffix).append(" ");
        }
        return res.substring(0,res.length()-1);
    }
}
