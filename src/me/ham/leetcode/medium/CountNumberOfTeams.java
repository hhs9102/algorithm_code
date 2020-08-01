package me.ham.leetcode.medium;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/count-number-of-teams/submissions/
public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int ratingLength = rating.length;
        int[] reverseRating = IntStream.range(0, ratingLength).map(i -> rating[ratingLength -i-1]).toArray();

        return getPossibleTeamsCount(rating)+getPossibleTeamsCount(reverseRating);
    }

    //O(n^3)
    public int getPossibleTeamsCount(int[] rating){
        int count = 0;
        for(int i=0; i<rating.length-2; i++){
            for(int j=i+1; j<rating.length-1 & i<j; j++){
                if(rating[i] < rating[j]){
                    for(int k=j+1; k<rating.length & j<k; k++){
                        if(rating[j] < rating[k]){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        assertEquals(3, numTeams(new int[]{2,5,3,4,1}));
        assertEquals(3, numTeams(new int[]{3,6,7,5,1}));
    }
}
