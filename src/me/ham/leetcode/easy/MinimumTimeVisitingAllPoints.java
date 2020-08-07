package me.ham.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/minimum-time-visiting-all-points/submissions/
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;

        for(int i=1; i<points.length; i++){

            int x = Math.abs(Math.subtractExact(points[i-1][0], points[i][0]));
            int y = Math.abs(Math.subtractExact(points[i-1][1], points[i][1]));

            int min = Math.min(x,y);
            int sub = Math.abs(Math.subtractExact(x,y));

            result = result+min+sub;
        }
        /** best practice
        for(int i=1; i<points.length; i++){
            result += Math.max(Math.abs(points[i-1][0]-points[i][0]), Math.abs(points[i-1][1]-points[i][1]));
        }
        */

        return result;
    }

    @Test
    public void test(){
        assertEquals(7, minTimeToVisitAllPoints(new int[][]{{1,1}, {3,4}, {-1,0}}));
    }
}
