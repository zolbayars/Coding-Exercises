package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.*;

/*
    Purpose: Given a set, find all subsets of it
 */

public class Subset {

    // {4, 7, 1, 13}
    //
    public List<List<Integer>> getSubLists(List<Integer> list){
        List<List<Integer>> accList = new ArrayList<>();
        return getSubLists(list, accList);
    }

    private List<List<Integer>> getSubLists(List<Integer> list, List<List<Integer>> accList){
        System.out.println("list size = " + list.size());
        System.out.println("accList size = " + accList.size());
        if(list.isEmpty()){
            return null;
        }

        if(list.size() == 1){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(list.get(0));
            System.out.println("list.get(0) = " + list.get(0));
            accList.add(tmpList);

            return accList;
        }

        List<Integer> subList = list.subList(0, list.size() - 1);
        List<List<Integer>> tmpAccList = getSubLists(subList, accList);
        if(tmpAccList != null){
            accList.addAll(tmpAccList);
        }

        return accList;
    }


}
