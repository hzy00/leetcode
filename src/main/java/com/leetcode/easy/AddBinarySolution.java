package com.leetcode.easy;

import org.junit.Test;

public class AddBinarySolution {

    @Test
    public void test() throws Exception {

    }

    public String addBinary(String a, String b) {
        int len = a.length()>b.length()?a.length()+1:b.length()+1;
        char[] chs = new char[len];
        int al = a.length()-1,bl=b.length()-1;
        char carry = '0';
        while(al>-1 && bl>-1){
            chs[--len] = addChar(addChar(a.charAt(al),b.charAt(bl)),carry);
            carry = addChar(chs[len] ,(char)(a.charAt(al) | b.charAt(bl) | carry));
            al--;
            bl--;
        }
        while(al > -1){
            chs[--len] = addChar(a.charAt(al),carry);
            carry = addChar(chs[len] ,(char)(a.charAt(al) | carry));
            al--;
        }
        while(bl > -1){
            chs[--len] = addChar(b.charAt(bl),carry);
            carry = addChar(chs[len],(char)(carry | b.charAt(bl)));
            bl--;
        }
        if(carry == '1'){
            chs[--len] = carry;
        }
        return new String(chs,len,chs.length-len);
    }

    private char addChar(char ch1,char ch2){
        if(ch1=='1' && ch2 == '1') return '0';
        if(ch1 == '1' || ch2 == '1') return '1';
        return '0';
    }
}
