package com.leetcode.easy;

/**
 * Created by 75623 on 2018/5/8.
 */
public class NumberOfLineSolution {

    public int[] numberOfLines(int[] widths, String S) {
        if (S == null
                || S.length() < 1
                || widths == null
                || widths.length < 26) {
            return new int[]{0, 0};
        }

        int lines = 0, sum = 0;
        S = S.toLowerCase();
        for (char ch : S.toCharArray()) {
            sum += widths[ch - 'a'];
            if (sum > 100) {
                lines++;
                sum = widths[ch - 'a'];
            }
        }
        lines++;
        return new int[]{lines, sum};
    }
}
