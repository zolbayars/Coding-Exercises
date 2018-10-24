package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

/*
    Purpose: A magic in an array Arr is where the Arr[i] = i. Find that index.

    Why distinct integers?
 */

public class MagicIndex {

    public int findMagicIndex(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == i){
                return i;
            }
        }
        return -1;
    }

}
