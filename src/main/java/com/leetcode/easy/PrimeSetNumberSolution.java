package com.leetcode.easy;

/**
 * Created by hzy on 18/5/20.
 */
public class PrimeSetNumberSolution {

    public int countPrimeSetBits(int L, int R) {
        int sum = 0;
        for (int i = L; i <= R; i++) {
            if(isPrime(Integer.bitCount(i))){
                sum++;
            }
        }
        return sum;
    }

    public boolean isPrime(int x) {
        return x == 2 || x == 3 || x == 5
                || x == 7 || x == 11 || x == 13 || x == 17 || x == 19;
    }
}
