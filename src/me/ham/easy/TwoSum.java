package me.ham.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

public class TwoSum {

    public int[] twoSum(int[] nums, int target){
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for(int i=0; i<numList.size(); i++){
            for(int j=i+1; j<numList.size(); j++){
                if(target == numList.get(i) + numList.get(j)){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{};
    }

    @Test
    public void test(){
        int[] expected = {0,1};

        assertArrayEquals(expected, twoSum(new int[]{2,7,11,15}, 9));
    }
}
