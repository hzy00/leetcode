package com.leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 75623 on 2018/5/16.
 */
public class ReconstructQueueSolution {

    @Test
    public void test(){
        reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }

    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length<2){
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0]?o2[0]-o1[0]:o1[1]-o2[1];
            }
        });
        List<int[]> tmpList = new ArrayList<int[]>(people.length);
        for(int i=0;i<people.length;i++){
            if(people[i][1]<tmpList.size()) {
                tmpList.add(people[i][1], people[i]);
            }else{
                tmpList.add(people[i]);
            }
        }
        for(int i=0;i<tmpList.size();i++){
            people[i] = tmpList.get(i);
        }
        return people;
    }
}
