package me.ham.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<groupSizes.length; i++){
            int sizeKey = groupSizes[i];
            if(map.get(sizeKey) == null){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sizeKey, list);
            }else{
                map.get(sizeKey).add(i);
            }

            if(map.get(sizeKey).size() == sizeKey){
                result.add(map.get(sizeKey));
                map.put(sizeKey, null);
            }
        }

        return result;
    }

    @Test
    public void test(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(4);
        list3.add(6);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(list1);
        expected.add(list2);
        expected.add(list3);

        Assert.assertArrayEquals(expected.toArray(), groupThePeople(new int[]{3,3,3,3,3,1,3}).toArray());
    }
}
