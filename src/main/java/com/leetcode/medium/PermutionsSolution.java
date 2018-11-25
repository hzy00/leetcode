package com.leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutionsSolution {

    @Test
    public void test(){
        permute(new int[]{0,-1,1});
    }

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length<1) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        boolean[] flags = new boolean[nums.length];
        List<Integer> list = new ArrayList<>(nums.length);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new StringBuilder(),nums.length,nums,flags,set,list,ans);
        return ans;
    }

    private void dfs(StringBuilder sb,int len,int[] nums,boolean[] flags,Set<String> set,List<Integer> list,List<List<Integer>> ans){
        if(len == 0){
            ans.add(new ArrayList(list));
        }else{
            for(int i=0;i<nums.length;i++){
                if(!flags[i]){
                    flags[i] = true;
                    sb.append(nums[i]);
                    if(set.contains(sb.toString())) continue;
                    set.add(sb.toString());
                    list.add(nums[i]);

                    dfs(sb,len-1,nums,flags,set,list,ans);

                    sb.delete(sb.length()-String.valueOf(nums[i]).length(),sb.length());
                    list.remove(list.size()-1);
                    flags[i] = false;
                }
            }
        }
    }
}
