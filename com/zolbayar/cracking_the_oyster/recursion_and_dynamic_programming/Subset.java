package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.*;

/*
    Purpose: Given a set, find all subsets of it

    Insight: Classic case for using the Base Case & Build approach
             Implement by hand with some simple test cases!
             The base case is where the index = size
             Could've stored list info in binary strings (1011 means the first and the last elements are in the list)

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

    // After I saw the solution
    public List<List<Integer>> getSubSets(List<Integer> set, int index){
        List<List<Integer>> allSubsets;
//        System.out.println("index = " + index);

        // base case
        if(index == set.size()){
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        }else{
            allSubsets = getSubSets(set, index + 1);
            int item = set.get(index);

            List<List<Integer>> moreSubsets = new ArrayList<>();
            for (List<Integer> integers : allSubsets) {
                List<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(integers);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;

    }

    // {4, 7, 1, 13}
    // My way
    public List<List<Integer>> getSubLists(List<Integer> list){
        List<List<Integer>> accList = new ArrayList<>();
        return getSubLists(list, list.size(), accList);
    }

    private List<List<Integer>> getSubLists(List<Integer> list, int n, List<List<Integer>> accList){

        System.out.println("n = " + n);

        if(n == 0){
            List<Integer> newList = new ArrayList<>();
            newList.add(null);

            accList.add(newList);
            return accList;
        }

//        if(n == 1){
//            List<Integer> newList = new ArrayList<>();
//            newList.add(list.get(0));
//
//            accList.add(newList);
//            return accList;
//        }

        List<List<Integer>> accumulatedLists = getSubLists(list, n - 1, accList);

        System.out.println("accumulatedLists.size() = " + accumulatedLists.size() + " n: " + n);
        
        for (int i = 0; i < accumulatedLists.size(); i++) {
            
            List<Integer> listToChange = accumulatedLists.get(i);

            listToChange.add(list.get(n - 1));
            System.out.println("list.get(n - 1) = " + list.get(n - 1));
            accumulatedLists.set(i, listToChange);
        }

        List<Integer> listToAdd = accumulatedLists.get(0);

        for (int j = 0; j < listToAdd.size(); j++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(listToAdd.get(j));
            accumulatedLists.add(newList);
        }

        List<Integer> nList = new ArrayList<>();
        nList.add(list.get(n - 1));
        accumulatedLists.add(nList);

        return accumulatedLists;
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
