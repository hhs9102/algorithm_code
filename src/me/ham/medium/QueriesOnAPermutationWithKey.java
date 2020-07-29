package me.ham.medium;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class QueriesOnAPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];

        //settings
        List<Integer> permutation = new ArrayList<>();
        for(int i=0; i<m; i++){
            permutation.add(i+1);
        }

        int resultIndex=0;
        for(int query : queries){
            int index = permutation.indexOf(query); //몇번째인지
            Integer number = permutation.get(index);//index번째의 값 저장


            result[resultIndex++] = index;  //결과할당

            //index번째의 값 제일 앞으로 이동
            permutation.remove(index);
            permutation.add(0, number);
        }

        return result;
    }

    @Test
    public void test(){
        assertArrayEquals(new int[]{2,1,2,1}, processQueries(new int[]{3,1,2,1}, 5));
    }
}
