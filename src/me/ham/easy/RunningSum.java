package me.ham.easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RunningSum {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for(int i=1;i<nums.length; i++){
            result[i] = nums[i]+result[i-1];
        }

        return result;
    }

    @Test
    public void test(){
        assertArrayEquals(new int[]{1,3,6,10}, runningSum(new int[]{1,2,3,4}));
    }
}
