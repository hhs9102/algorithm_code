package me.ham.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public int search(int[] nums, int target) {
        int result = -1;

        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = (right+left)/2;

            if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return result;
    }

    @Test
    public void test(){
        assertEquals(4, search(new int[]{-1,0,3,5,9,12}, 9));
        assertEquals(1, search(new int[]{2,5}, 5));
        assertEquals(-1, search(new int[]{2}, 5));
        assertEquals(0, search(new int[]{2}, 2));
        assertEquals(-1, search(new int[]{-1,0,3,5,9,12}, 13));
    }
}
