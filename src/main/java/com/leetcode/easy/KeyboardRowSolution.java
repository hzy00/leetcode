package com.leetcode.easy;

import java.util.*;

/**
 * Created by hzy on 18/5/13.
 */
public class KeyboardRowSolution {

    private static Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    static {
        map.put('q'-'a', 1);
        map.put('w'-'a', 1);
        map.put('e'-'a', 1);
        map.put('r'-'a', 1);
        map.put('t'-'a', 1);
        map.put('y'-'a', 1);
        map.put('u'-'a', 1);
        map.put('i'-'a', 1);
        map.put('o'-'a', 1);
        map.put('p'-'a', 1);
        map.put('a'-'a', 2);
        map.put('s'-'a', 2);
        map.put('d'-'a', 2);
        map.put('f'-'a', 2);
        map.put('g'-'a', 2);
        map.put('h'-'a', 2);
        map.put('j'-'a', 2);
        map.put('k'-'a', 2);
        map.put('l'-'a', 2);
        map.put('z'-'a', 3);
        map.put('x'-'a', 3);
        map.put('c'-'a', 3);
        map.put('v'-'a', 3);
        map.put('b'-'a', 3);
        map.put('n'-'a', 3);
        map.put('m'-'a', 3);
    }

    public String[] findWords(String[] words) {
        if(words == null || words.length < 1){
            return words;
        }
        String[] arr = new String[0];
        for(String word:words){
            if(word == null || word.length()<1){
                continue;
            }
            int row = parseCharIdx(word.charAt(0));
            row = map.get(row);
            for(int i=1;i<word.length();i++){
                if(map.get(parseCharIdx(word.charAt(i))) != row){
                    row = -1;
                    break;
                }
            }
            if(row != -1){
                arr = Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1] = word;
            }
        }
        return arr;
    }

    private int parseCharIdx(char c){
        int r = c - 'a';
        return r>=0?r:c-'A';
    }
}
