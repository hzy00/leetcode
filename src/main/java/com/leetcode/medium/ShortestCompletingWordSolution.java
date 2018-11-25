package com.leetcode.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWordSolution {

    @Test
    public void test(){
        shortestCompletingWord("1s3 PSt" ,new String[]{"step","steps","stripe","stepple"});
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character,Integer> map = new HashMap<>(8);
        int length = 0;
        for(char ch:licensePlate.toCharArray()){
            length+=add(map,ch);
        }

        String ans = null;
        for(String word:words){
            if(word.length() >= length && (ans == null || word.length() < ans.length())){
                Map<Character,Integer> tmp = new HashMap<>(8);
                for(char ch:word.toCharArray()){
                    if(Character.isLetter(ch)){
                        char key = Character.toLowerCase(ch);
                        if(map.containsKey(key)){
                            add(tmp,key);
                        }
                    }
                }
                if(match(map,tmp)){
                    ans = word;
                }
            }
        }
        return ans;
    }

    private int add(Map<Character,Integer> map,char ch){
        if(Character.isLetter(ch)){
            int count = 1;
            char key = Character.toLowerCase(ch);
            if(map.containsKey(key)) count+=map.get(key);
            map.put(key,count);
            return 1;
        }
        return 0;
    }

    private boolean match(Map<Character,Integer> map1,Map<Character,Integer> map2){
        for(char key:map1.keySet()){
            if(!map2.containsKey(key) || map2.get(key) < map1.get(key)){
                return false;
            }
        }
        return true;
    }
}
