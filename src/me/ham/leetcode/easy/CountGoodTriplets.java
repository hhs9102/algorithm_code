package me.ham.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int size = arr.length;
        int count = 0;
        for(int i=0; i<size-2; i++){
            for(int j=i+1; j<size-1 ;j++){
                if(Math.abs(arr[i] - arr[j]) <= a){
                    for(int k=j+1; k<size; k++){
                        if(Math.abs(arr[j]-arr[k])<=b
                        && Math.abs(arr[i]-arr[k])<=c){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    @Test
    public void solution(){
        assertEquals(4, countGoodTriplets(new int[]{3,0,1,1,9,7}, 7,2,3));
    }
}
