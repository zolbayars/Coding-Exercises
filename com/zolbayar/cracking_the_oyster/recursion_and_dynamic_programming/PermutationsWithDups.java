package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.*;

/*
    Can't improve the worst case performance. But at least when the there are multiple same letters, it should fare better.
    Just checking if there are duplicate element in the list is not enough
 */

public class PermutationsWithDups {

    // aba => aab, aba, baa
    public List<String> getPermutations(String string){
        char[] chars = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char aChar : chars) {

            try {
                int currentCount = map.get(aChar);
//                System.out.println(currentCount);
                if (currentCount > -1) {
                    map.put(aChar, ++currentCount);
                } else {
                    map.put(aChar, 1);
                }
            }catch (Exception ex){
                map.put(aChar, 1);
            }

        }

        System.out.println(map);


        return getPermutation(map);
    }

    // aabc
    // abca, abac, acab, acba, aabc, aacb,
    // baac, baca, , acba, aabc, aacb,

    /*
    a + {a: 1, b: 1, c:1} => a + {a: 0, b: 1, c: 1} => b + {a: 0, b: 0, c: 1} => c

    aabc

     */
    List<String> getPermutation(Map<Character, Integer> countMap){

        Map<Character, Integer> countMapLocal = countMap;
        Map<Character, Integer> countMapLocalForCheck = countMap;

        char oneValue = 0;
        boolean allButOneValue = false;

        // the base case when there are only 1 char left
        for(Map.Entry<Character, Integer> count: countMapLocalForCheck.entrySet()){

            if(count.getValue() > 0){
                if(oneValue != 0){
                    allButOneValue = false;
                }else{
                    allButOneValue = true;
                    oneValue = count.getKey();
                }
            }
        }

        if(allButOneValue){
            List<String> result = new ArrayList<String>();
            result.add(oneValue + "");
            return result;
        }

        List<String> result = new ArrayList<>();

        countMapLocal.replaceAll((key, value) -> {
            if(value > 0){
                System.out.println("key = " + key);
                System.out.println("value = " + value);
                Map<Character, Integer> newMap = countMapLocal;
                newMap.put(key, value - 1);
                List<String> suffices = getPermutation(newMap);
                for(String suffix: suffices){
                    result.add(key + suffix);
                }
                return value - 1;
            }
            return value;
        });

        return result;
    }
}
