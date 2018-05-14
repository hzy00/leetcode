package com.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hzy on 18/5/13.
 */
public class BattleShipSolution {

    @Test
    public void test() {
        Assert.assertEquals(2, countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}}));
    }

    public int countBattleships(char[][] board) {
        if (board == null || board.length < 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            char[] tmp = board[i];
            if (tmp == null || tmp.length < 1) {
                continue;
            }
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] == 'X' && (j == 0 || board[i][j - 1] != 'X')
                        && (i == 0 || board[i - 1][j] != 'X')) {
                    sum++;
                }
            }
        }
        return sum;
    }

}
