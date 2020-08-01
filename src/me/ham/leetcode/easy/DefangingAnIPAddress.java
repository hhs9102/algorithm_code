package me.ham.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/defanging-an-ip-address/
public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    @Test
    public void test(){
        assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
    }
}
