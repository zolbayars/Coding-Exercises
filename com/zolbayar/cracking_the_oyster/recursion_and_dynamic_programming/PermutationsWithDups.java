package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.*;

/*
    Can't improve the worst case performance. But at least when the there are multiple same letters, it should fare better.
    Just checking if there are duplicate element in the list is not enough

    Insight: My solution was too complex. Net yet fully grasped the base case and recurse approach.
        You can check the base case with a separate variable
 */

public class PermutationsWithDups {

    // aba => aab, aba, baa
    public List<String> getPermutations(String string){
        Map<Character, Integer> map = new HashMap<>();

        for (char aChar : string.toCharArray()) {
            try {
                if(map.containsKey(aChar)){
                    map.put(aChar, map.get(aChar) + 1);
                }else{
                    map.put(aChar, 1);
                }
            }catch (Exception ex){
                map.put(aChar, 1);
            }
        }

        System.out.println(map);

        ArrayList<String> result = new ArrayList<>();

        return getPermutation(map, "", string.length(), result, "");
//        return null;
    }

    // aabc
    // abca, abac, acab, acba, aabc, aacb,
    // baac, baca, , acba, aabc, aacb,
    List<String> getPermutation(Map<Character, Integer> countMap, String prefix, int remaining,
                                ArrayList<String> result, String printPrefix){

        System.out.println(printPrefix + "countMap: " + countMap + " prefix: " + prefix +
                " remaining: " + remaining + " result: " + result.size());

        if(remaining == 0){
            result.add(prefix);
            return result;
        }

        for(char countChar : countMap.keySet()){
//            System.out.println("countChar = " + countChar);
            int count = countMap.get(countChar);
            if(count > 0){
                countMap.put(countChar, count - 1);
                getPermutation(countMap, countChar + prefix, remaining - 1, result, printPrefix + "   ");
                countMap.put(countChar, count);
            }
        }

        return result;
    }
}
