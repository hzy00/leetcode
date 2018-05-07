package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 75623 on 2018/5/6.
 */
public class RouteCircleSolution {

    @Test
    public void test(){
        Assert.assertTrue(judgeCircle("LR"));
        Assert.assertTrue(judgeCircle("UUDD"));
        Assert.assertFalse(judgeCircle("DURDLDRRLL"));
    }

    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length()<=1){
            return false;
        }
        int x=0,y=0;
        for(int i=0;i<moves.length();i++){
            switch (moves.charAt(i)){
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    break;
            }
        }
        if(x == 0 && y == 0){
            return true;
        }
        return false;
    }
}
