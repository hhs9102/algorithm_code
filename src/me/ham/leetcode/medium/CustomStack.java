package me.ham.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/design-a-stack-with-increment-operation/
public class CustomStack {
    private Object[] elements;
    private int index = -1;  //현재 index를 가르킨다.

    public CustomStack(int maxSize) {
        elements = new Object[maxSize];
    }

    public void push(int x) {
        if(!isFull()){
            elements[++index] = x;
        }
    }

    public int pop() {
        if(isExists()){
            int result = (int)elements[index];
            elements[index] = null; //메모리 해제
            index--;
            return result;
        }else{
            return -1;
        }
    }

    public void increment(int k, int val) {
        k = Math.min(k, elements.length);

        for(int i=0; i<k && elements[i]!= null; i++){
            elements[i] = (int)elements[i]+val;
        }
    }

    public boolean isExists(){
        return index > -1;
    }

    public boolean isFull(){
        return index == elements.length-1;
    }


    public static class CustomStackTest{
        @Test
        public void test(){
            CustomStack customStack = new CustomStack(3);
            customStack.push(1);
            customStack.push(2);
            assertEquals(2,customStack.pop());

            customStack.push(2);
            customStack.push(3);
            customStack.push(4);

            customStack.increment(5,100);
            customStack.increment(2,100);
            assertEquals(103, customStack.pop());
            assertEquals(202, customStack.pop());
            assertEquals(201, customStack.pop());
            assertEquals(-1, customStack.pop());
        }
    }
}

