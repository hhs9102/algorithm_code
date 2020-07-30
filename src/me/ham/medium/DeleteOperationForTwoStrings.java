package me.ham.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/delete-operation-for-two-strings/submissions/
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] result = new int[word1.length()+1][word2.length()+1];

        for (int i=0; i<=word1.length(); i++){
            for(int j=0; j<=word2.length(); j++){
                if(i==0 || j==0){
                    result[i][j]=0;
                }else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        result[i][j] = result[i-1][j-1]+1;
                    }else{
                        result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
                    }
                }
            }
        }
        int sameLength = result[word1.length()][word2.length()];
        return (word1.length() - sameLength)+(word2.length()-sameLength);
    }

    @Test
    public void test(){
        assertEquals(2, minDistance("sea","eat"));
        assertEquals(1, minDistance("","a"));
    }
}
