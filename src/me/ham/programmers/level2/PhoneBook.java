package me.ham.programmers.level2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
public class PhoneBook {
    public boolean solution(String[] phone_book) {

        for(int i=0; i< phone_book.length; i++){
            String phone = phone_book[i];
            for(int j=0; j< phone_book.length; j++){
                if(i!=j && phone_book[j].startsWith(phone)){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        assertEquals(false, solution(new String[]{"119", "97674223", "1195524421"}));
    }
}
