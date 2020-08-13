package me.ham.leetcode.medium;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/sort-integers-by-the-power-value/
public class SortIntegersByThePowerValue {
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> powerMap = new HashMap<>();
        for(int i=lo; i<=hi; i++){
            List<Integer> list = new LinkedList<>();
            int target = i;
            while(target!=1){
                list.add(target);
                target = calculate(target);
            }
            powerMap.put(i, list.size());
        }


        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? a.getKey()-b.getKey() : a.getValue()-b.getValue()
        );

        powerMap.entrySet().forEach(entry->{
            queue.add(entry);
        });

        for(int i=1; i<k; i++){
//            System.out.println("["+i+"]"+ queue.poll());
            queue.poll();
        }
//        System.out.println(queue.peek());
        return queue.poll().getKey();
    }


    private int calculate(int target) {
        return target%2==0 ? target/2 : (3*target)+1;
    }

    /**
     * TODO PriorityQueue 정렬 조건 추가 확인 필요
     * 절반의 성공? PriorityQueue의 어느 한계선에서는 value가 같을때, key의 순서를 보장하지 못한다?
     */
    @Test
    public void test(){
        assertEquals(13, getKth(12,15,2));
        assertEquals(1, getKth(1,1,1));
        assertEquals(7, getKth(7,11,4));
        assertEquals(13, getKth(10,20,5));
        assertEquals(570, getKth(1,1000,777));
//        assertEquals(811, getKth(118,974,825));
    }
}
