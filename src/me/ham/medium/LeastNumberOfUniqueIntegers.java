package me.ham.medium;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class LeastNumberOfUniqueIntegers {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Map<Integer, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        SortedSet<Map.Entry<Integer, Long>> entries = entriesSortedByValues(collect);
        System.out.println(entries);

        for(Map.Entry<Integer, Long> entry : entries){
            if(k ==0){
                break;
            }

            while(entry.getValue()-1 > -1){
                entry.setValue(entry.getValue()-1);
                k--;

                if(entry.getValue()==0 || k==0){
                    break;
                }
            }
            if(entry.getValue() ==0){
                entries.remove(entry);
            }
        }

        return (int)collect
                .entrySet()
                .stream()
                .filter(e-> e.getValue()!=0)
                .count() - k;
    }

    public static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }


    @Test
    public void test(){
        assertEquals(1, findLeastNumOfUniqueInts(new int[]{5,5,4}, 1));
        assertEquals(2, findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }
}
