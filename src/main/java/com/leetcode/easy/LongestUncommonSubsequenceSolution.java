package com.leetcode.easy;

/**
 * Created by hzy on 18/5/20.
 */
public class LongestUncommonSubsequenceSolution {

    public int findLUSlength(String a, String b) {
        if (isEmpty(a) && isEmpty(b)) {
            return -1;
        }
        if (a.equals(b)) {
            return -1;
        }
        if (a.length() != b.length()) {
            return a.length() > b.length() ? a.length() : b.length();
        }
        return a.length();
    }

    public boolean isEmpty(String str) {
        return str == null || str.length() < 1;
    }
}
