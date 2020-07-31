package me.ham.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSumStream(int n) {
        List<Integer> number = new ArrayList<>();

        while (n!=0){
            int remainder = n%10;
            number.add(remainder);
            n = n/10;
        }

        Integer multipleValue = number.stream()
                .reduce(1, (n1, n2) -> n1 * n2);

        Integer sumValue = number.stream()
                .reduce(0, (n1,n2)->n1+n2);
        return multipleValue - sumValue;
    }

    public int subtractProductAndSum(int n) {
        int multipleValue = 1;
        int sumValue = 0;

        while (n!=0){
            int remainder = n%10;
            multipleValue *= remainder;
            sumValue += remainder;
            n = n/10;
        }

        return multipleValue - sumValue;
    }

    @Test
    public void test(){
        assertEquals(15, subtractProductAndSum(234));
    }
}
