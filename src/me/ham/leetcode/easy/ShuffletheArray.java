package me.ham.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ShuffletheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        int index =0;
        for(int i=0, j=nums.length/2; i<nums.length/2; i++, j++){
            result[index++] = nums[i];
            result[index++] = nums[j];
        }
        return result;
    }


    @Test
    public void test(){
        assertArrayEquals(new int[]{2,3,5,4,1,7}, shuffle(new int[]{2,5,1,3,4,7}, 3));
    }
}
