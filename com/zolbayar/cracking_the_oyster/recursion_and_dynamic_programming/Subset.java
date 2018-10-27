package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.*;

/*
    Purpose: Given a set, find all subsets of it
 */

public class Subset {

    // {4, 7, 1, 13}
    //
    public List<List<Integer>> getSubsets(List<Integer> set){
        List<List<Integer>> combinedSets = new ArrayList<>();
        return getSubsets(set, combinedSets);
    }

    private List<List<Integer>> getSubsets(List<Integer> list, List<List<Integer>> accList){
        if(list.isEmpty()){
            return null;
        }

        if(list.size() == 1){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(list.get(0));
            accList.add(tmpList);
            return accList;
        }

        List<Integer> subList = list.subList(0, list.size() - 2);
        List<List<Integer>> tmpAccList = getSubsets(subList, accList);
        if(tmpAccList != null){
            accList.addAll(tmpAccList);
        }

        return accList;
    }


}
