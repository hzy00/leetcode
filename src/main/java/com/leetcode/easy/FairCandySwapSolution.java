package com.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by hzy on 18/8/20.
 */
public class FairCandySwapSolution {

    @Test
    public void test(){
        int[] ans = fairCandySwap(new int[]{35,17,4,24,10},new int[]{63,21});
        Assert.assertTrue(ans[0] == 24);
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA=0,sumB=0;
        for(int num:A){
            sumA+=num;
        }
        for(int num:B){
            sumB+=num;
        }
        int gap = (sumA-sumB)/2;
        for(int i=0;i<A.length;i++){
            int l=0,r=B.length,mid = r/2;
            while(l<r){
                int t = A[i]-B[mid];
                if(t == gap){
                    return new int[]{A[i],B[mid]};
                }else if(t > gap){
                    l = mid+1;
                }else if(t < gap){
                    r = mid;
                }
                mid = (l+r)/2;
            }
        }
        return null;
    }
}
