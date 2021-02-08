package me.ham.leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(Integer num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        return countMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(1))
                .map(Map.Entry::getKey)
                .reduce(0, (a,b)->a+b);
    }

    @Test
    public void solution(){
        assertEquals(4,sumOfUnique(new int[]{1,2,3,2}));
        assertEquals(0,sumOfUnique(new int[]{1,1,1,1,1}));
        assertEquals(15,sumOfUnique(new int[]{1,2,3,4,5}));
    }
}
