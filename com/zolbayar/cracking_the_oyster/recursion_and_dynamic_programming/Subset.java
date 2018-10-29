package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.*;

/*
    Purpose: Given a set, find all subsets of it

    Insight: Classic case for using the Base Case & Build approach
             Implement by hand with some simple test cases!

            set: {}
            subsets: {}

            set: {a1}
            subsets: {}, {a1}

            set: {a1, a2}
            subsets: {}, {a1}, {a2}, {a1, a2}

            set: {a1, a2, a3}
            subsets: {}, {a1}, {a2}, {a3}, {a1, a2}, {a2, a3}, {a1, a3}, {a1, a2, a3}

            The difference between P(2) and P(3) is where the things started to get interesting
            P(n) = P(n - 1) + n
 */

public class Subset {

    // {4, 7, 1, 13}
    //
    public List<List<Integer>> getSubLists(List<Integer> list){
        List<List<Integer>> accList = new ArrayList<>();
        return getSubLists(list, list.size() - 1, accList);
    }

    private List<List<Integer>> getSubLists(List<Integer> list, int n, List<List<Integer>> accList){
       if(n == 0){
           List<Integer> tmpList = new ArrayList<>();
           tmpList.add(null);
           tmpList.add(list.get(0));
           accList.add(tmpList);
           return accList;
       }

       List<List<Integer>> prevLists = getSubLists(list, n - 1, accList);
       List<List<Integer>> prevListsClone = prevLists;

        printList(prevLists, "prevLists before");

        for (int i = 0; i < prevListsClone.size(); i++) {
            prevListsClone.get(i).add(list.get(n));

            for (Integer integer : prevListsClone.get(i)) {

            }
        }

        prevLists.addAll(prevListsClone);

        printList(prevLists, "prevLists");

        return prevLists;
    }

    private void printList(List<List<Integer>> list, String name){
        System.out.println("name = " + name);
        for (List<Integer> integerList : list) {
            for (Integer integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


}
