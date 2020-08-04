package me.ham.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i:nums){
            if(String.valueOf(i).length()%2 == 0){
                count++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        assertEquals(2, findNumbers(new int[]{12,345,2,6,7896}));
        assertEquals(1, findNumbers(new int[]{555,901,482,1771}));
    }
}