package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by 75623 on 2018/5/6.
 */
public class UniqueMorseCodeSolution {

    private String[] morseCodes = new  String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    @Test
    public void test(){
        Assert.assertEquals(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}),2);
        Assert.assertEquals(uniqueMorseRepresentations(new String[]{"hvqs","ssagb","ssxhn","huelf","eqqal"}),3);
    }

    public int uniqueMorseRepresentations(String[] words) {
        if(words == null
                || words.length < 1){
            return 0;
        }
        if(words.length == 1){
            return 1;
        }

        Set<String> resultSet = new HashSet<String>();
        for(int i=0;i<words.length;i++){
            if(words[i] == null || words[i].length() < 1){
                continue;
            }
            StringBuilder tmp = new StringBuilder();
            for(int j=0;j<words[i].length();j++){
                tmp.append(morseCodes[words[i].toUpperCase().codePointAt(j)-65]);
            }
            resultSet.add(tmp.toString());
        }
        return resultSet.size();
    }

    public int uniqueMorseRepresentations(List<String> words, int start){
        if(words == null
                || words.size() < 1){
            return 0;
        }
        if(words.size() == 1){
            return 1;
        }
        String firstWord = words.get(0);
        if(firstWord == null || firstWord.length() < 1){
            words.remove(0);
            return uniqueMorseRepresentations(words,start);
        }
        List<String> diffStr = new ArrayList<String>();
        List<String> sameStrs = new ArrayList<String>();
        sameStrs.add(firstWord);
        for(int i=1;i<words.size();i++){
            if(words.get(i) == null || words.get(i).length() < 1 || firstWord.equals(words.get(i))){
                continue;
            }
            StringBuilder aMorse = new StringBuilder();
            StringBuilder bMorse = new StringBuilder();

            for(int j=0;j<=start && j < firstWord.length();j++){
                aMorse.append(morseCodes[firstWord.toUpperCase().codePointAt(j) - 65]);
            }
            for(int j=0;j<=start && j < words.get(i).length();j++){
                bMorse.append(morseCodes[words.get(i).toUpperCase().codePointAt(j) - 65]);
            }
            int startRes = startWith(aMorse.toString(),bMorse.toString());
            if(start >= words.get(i).length() - 1
                    && start >= words.get(i).length() - 1
                    && aMorse.toString().equals(bMorse.toString())){
                continue;
            }
            if(startRes == 0
                    || (startRes == 1 && start >= words.get(i).length() - 1)
                    || (startRes == -1 && start >= firstWord.length() - 1)){
                diffStr.add(words.get(i));
            }else{
                sameStrs.add(words.get(i));
            }
        }

        return uniqueMorseRepresentations(sameStrs,start+1) + uniqueMorseRepresentations(diffStr,start);
    }

    public int startWith(String a,String b){
        if(a == null || b == null){
            return 0;
        }
        if(a.length()>b.length()){
            return a.startsWith(b)?1:0;
        }else{
            return b.startsWith(a)?-1:0;
        }
    }
}
