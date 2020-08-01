package me.ham.programmers.level2;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

//https://programmers.co.kr/learn/courses/30/lessons/42626
public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville){
            queue.add(i);
        }

        while (true){
            if(queue.size()>1 && queue.peek()<K){
                int first = queue.poll();
                int twice = queue.poll();
                queue.add(first + (twice*2));
                answer++;
            }else if(queue.peek() >= K){
                break;
            }else{
                answer = -1;
                break;
            }
        }

        return answer;
    }

    @Test
    public void test(){
        assertEquals(2, solution(new int[]{1,2,3,9,10,12}, 7));
    }
}
