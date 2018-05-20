package com.leetcode.easy;

/**
 * Created by hzy on 18/5/20.
 * 最笨的方法蛮力破解
 */
public class LargestAreaSolution {
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for(int i = 0;i<points.length-2;i++){
            for(int j=1;j<points.length-1;j++){
                for(int k=2;k<points.length;k++){
                    area = Math.max(area,getArea(points[i],points[j],points[k]));
                }
            }
        }
        return area;
    }

    public double getArea(int[] a, int[] b, int[] c) {
        return Math.abs(((a[0] - b[0]) * (a[1] - c[1]) - (a[0] - c[0]) * (a[1] - b[1])) / 2.0);
    }
}
