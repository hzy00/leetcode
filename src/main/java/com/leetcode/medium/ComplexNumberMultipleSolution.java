package com.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 75623 on 2018/5/12.
 */
public class ComplexNumberMultipleSolution {

    @Test
    public void test(){
        Assert.assertEquals("0+2i",complexNumberMultiply("1+1i", "1+1i"));
    }

    public String complexNumberMultiply(String a, String b) {
        String[] numA = a.split("\\+|i");
        String[] numB = b.split("\\+|i");
        int c, d, e, f,g,h;
        c = Integer.parseInt(numA[0]);
        d = Integer.parseInt(numA[1]);
        e = Integer.parseInt(numB[0]);
        f = Integer.parseInt(numB[1]);
        g = c * e - d * f;
        h = c * f + d * e;
        return String.valueOf(g) + "+" + String.valueOf(h)+"i";
    }
}
