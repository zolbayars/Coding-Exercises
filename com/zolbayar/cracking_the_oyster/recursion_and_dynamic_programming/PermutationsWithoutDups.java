package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDups {

    public List<String> getPermutations(String string){
        String[] chars = string.split("");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
            System.out.println("chars[i] = " + chars[i]);
        }

        List<String> result = getRealPermutation(list);
        for (String s : result) {
            System.out.println(s);
        }

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
            for (int i = 0; i < prevPerm.length(); i++) {
                String newPerm = insertCharAt(prevPerm, current, i);
                currentList.add(newPerm);
            }
        }

        return currentList;
    }

    private String insertCharAt(String s, String c,  int index){
        String before = s.substring(0, index);
        String after = s.substring(index);
        return before + c + after;
    }

    // ab -> a, b, ab
    // abc -> a, b, ab, c, ac, bc, abc
    // abcd -> a, b, ab, c, ac, bc, abc, d, ad, db, abd, cd, acd, bcd, abcd
    List<String> getPermutations(List<String> chars){

        if(chars.size() == 1){
            List<String> list = new ArrayList<>();
            list.add(chars.get(0));
            return list;
        }

        String current = chars.remove(chars.size() - 1);
//        System.out.println("current = " + current);
        List<String> currentList = new ArrayList<>();
        List<String> allPrevious = getPermutations(chars);

        currentList.addAll(allPrevious);

        currentList.add(current);
        for (String previous : allPrevious) {
            currentList.add(previous + current);
        }

        return currentList;
    }
}
