package com.leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75623 on 2018/5/10.
 * 深度优先搜索算法
 */
public class AllPathSourceToTargetSolution {

    @Test
    public void test(){
        int[][] graph = new int[4][];
        int[] arr = new int[]{1,2};
        graph[0] = arr;
        arr = new int[]{3};
        graph[1] = arr;
        arr = new int[]{1,3};
        graph[2] = arr;
        arr = new int[]{};
        graph[3] = arr;
        allPathsSourceTarget(graph);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null
                || graph.length < 1){
            return null;
        }
//        List<Integer> path = new ArrayList<Integer>();
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        path.add(0);
//        dfs(graph,0,result,path);
//        return result;
        return dfs(graph,0);
    }

    private void dfs(int[][]graph,int node,List<List<Integer>> result,List<Integer> path){
        if(node == graph.length-1){
            //find target
            result.add(new ArrayList<Integer>(path));
            return ;
        }
        for(int i:graph[node]){
            path.add(i);
            printArray(path);
            dfs(graph,i,result,path);
            path.remove(path.size()-1);
        }
    }

    private List<List<Integer>> dfs(int[][] graph,int node){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(node == graph.length -1){
            List<Integer> list = new ArrayList<Integer>();
            list.add(node);
            result.add(list);
            return result;
        }
        for(int i:graph[node]){
            List<List<Integer>> subPath = dfs(graph,i);
            for(List<Integer> path:subPath){
                path.add(0,node);
                printArray(path);
                result.add(path);
            }
        }
        return result;
    }

    private void printArray(List<Integer> list){
        for(int i:list){
            System.out.print(i+",");
        }
        System.out.println();
    }
}
