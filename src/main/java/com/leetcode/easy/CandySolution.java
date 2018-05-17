package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 75623 on 2018/5/14.
 */
public class CandySolution {

    public int distributeCandies(int[] candies) {
        if(candies == null || candies.length<1){
            return 0;
        }
        Set<Integer> kinds = new HashSet<Integer>();
        for(int candy:candies){
            kinds.add(candy);
        }
        return Math.min(candies.length/2,kinds.size());
    }
}
