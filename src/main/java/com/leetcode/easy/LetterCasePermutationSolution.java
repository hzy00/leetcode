package com.leetcode.easy;

import java.util.*;

/**
 * Created by hzy on 18/5/21.
 * 类似二叉树遍历的方法，深度优先和广度优先算法
 */
public class LetterCasePermutationSolution {

    public List<String> letterCasePermutation(String S) {
        if(S == null){
            return new ArrayList<String>();
        }
        if(S.length() == 0){
            return Arrays.asList(S);
        }
        Queue<String> queue = new ArrayDeque<String>();
        if(Character.isLetter(S.charAt(0))){
            queue.add(Character.toLowerCase(S.charAt(0))+"");
            queue.add(Character.toUpperCase(S.charAt(0))+"");
        }else{
            queue.add(S.charAt(0)+"");
        }
        for(int i=1;i<S.length();i++){
            final int size = queue.size();
            char ch = S.charAt(i);
            for(int j=0;j<size;j++){
                if(Character.isLetter(ch)){
                    queue.add(queue.peek()+Character.toLowerCase(ch));
                    queue.add(queue.poll()+Character.toUpperCase(ch));
                }else{
                    queue.add(queue.poll()+ch);
                }
            }
        }
        return new ArrayList<String>(queue);
    }

    private void dfs(String S,int idx,List<String> list){
        if(idx == S.length()){
            list.add(S);
            return;
        }
        char[] chars = S.toCharArray();
        char ch = chars[idx];
        if(Character.isLetter(ch)){
            chars[idx] = Character.toUpperCase(ch);
            String str = new String(chars);
            dfs(str, idx + 1, list);
            chars[idx] = Character.toLowerCase(ch);
            str = new String(chars);
            dfs(str,idx+1,list);
        }else {
            dfs(S,idx+1,list);
        }
    }
}
