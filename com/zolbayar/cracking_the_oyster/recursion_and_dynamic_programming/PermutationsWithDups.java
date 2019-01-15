package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//            try {
//
//            }catch (Exception ex){
//
//            }
            int currentCount = map.get(aChar);
            if (currentCount > -1) {
                map.put(aChar, currentCount++);
            } else {
                map.put(aChar, 1);
            }

        }

        System.out.println(map);

//        List<String> result = getRealPermutation(list);
//        for (String s : result) {
//            System.out.println(s);
//        }

        return null;
    }

    List<String> getRealPermutation(List<String> chars){
        if(chars.size() == 1){
            List<String> list = new ArrayList<>();
            list.add(chars.get(0));
            return list;
        }

        if(chars.size() == 2){
            List<String> list = new ArrayList<>();
            list.add(chars.get(0) + chars.get(1));
            list.add(chars.get(1) + chars.get(0));
            return list;
        }

        String current = chars.remove(chars.size() - 1);
        List<String> currentList = new ArrayList<>();

        List<String> prevPerms = getRealPermutation(chars);
        for (String prevPerm : prevPerms) {
            for (int i = 0; i <= prevPerm.length(); i++) {
                String newPerm = insertCharAt(prevPerm, current, i);
//                if(currentList.indexOf(newPerm) < 0){
                    currentList.add(newPerm);
//                }

            }
        }

        return currentList;
    }

    private String insertCharAt(String s, String c,  int index){
        String before = s.substring(0, index);
        String after = s.substring(index);
        return before + c + after;
    }
}
