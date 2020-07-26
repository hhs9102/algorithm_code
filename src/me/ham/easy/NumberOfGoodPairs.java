package me.ham.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        assertEquals(4, numIdenticalPairs(new int[]{1,2,3,1,1,3}));
        assertEquals(6, numIdenticalPairs(new int[]{1,1,1,1}));
        assertEquals(0, numIdenticalPairs(new int[]{1,2,3}));

    }
}
