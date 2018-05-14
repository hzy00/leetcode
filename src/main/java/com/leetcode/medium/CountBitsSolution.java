package com.leetcode.medium;

/**
 * Created by 75623 on 2018/5/14.
 */
public class CountBitsSolution {

    /**
     * 根据规律第n个数2进制1的个数是第n/2个数的结果+0/1
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
