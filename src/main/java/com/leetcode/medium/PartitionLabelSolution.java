package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75623 on 2018/5/11.
 */
public class PartitionLabelSolution {

    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length()<1){
            return null;
        }
        List list = new ArrayList();
        if(S.length() == 1){
            list.add(1);
            return list;
        }
        partitionLabels(S,0,list);
        return list;
    }

    public void partitionLabels(String S,int start,List<Integer> list) {
        if(start >= S.length()){
            return;
        }
        int lstIdx = S.lastIndexOf(S.charAt(start));
        for(int i=start+1;i<lstIdx;i++){
            int tmp = S.lastIndexOf(S.charAt(i));
            if(tmp> lstIdx){
                lstIdx = tmp;
            }
        }
        list.add(lstIdx+1-start);
        partitionLabels(S,lstIdx+1,list);
    }

    public List<Integer> partitionLabels(String S,int start){
        if(start >= S.length()){
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<Integer>();
        int lstIdx = S.lastIndexOf(S.charAt(start));
        for(int i=start+1;i<lstIdx;i++){
            int tmp = S.lastIndexOf(S.charAt(i));
            if(tmp> lstIdx){
                lstIdx = tmp;
            }
        }
        list.add(lstIdx+1-start);
        list.addAll(partitionLabels(S,lstIdx+1));
        return list;

    }
}
