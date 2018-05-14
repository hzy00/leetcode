package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75623 on 2018/5/14.
 */
public class BaseBallGameSolution {

    public int calPoints(String[] ops) {
        if(ops == null || ops.length<1){
            return 0;
        }
        List<Integer> scores = new ArrayList<Integer>();
        for(String str:ops){
            if("+".equals(str)){
                scores.add(scores.get(scores.size()-1)+scores.get(scores.size()-2));
            }else if("C".equals(str)){
                scores.remove(scores.size()-1);
            }else if("D".equals(str)){
                scores.add(scores.get(scores.size()-1)*2);
            }else{
                scores.add(Integer.valueOf(str));
            }
        }
        int sum = 0;
        for(Integer i:scores){
            sum+=i;
        }
        return sum;
    }
}
