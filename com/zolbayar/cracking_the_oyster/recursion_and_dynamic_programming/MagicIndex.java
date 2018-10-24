package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

/*
    Purpose: A magic index in an array Arr is where the Arr[i] = i. Find that index.

    Why distinct integers?
 */

public class MagicIndex {

    public int findMagicIndex(int[] arr){

        return findMagicIndex(arr, 0, arr.length - 1);
    }

    private int findMagicIndex(int[] arr, int start, int end){

        if(start > end){
            return -1;
        }

        int middle = (end + start) / 2;

        if(arr[middle] == middle){
            return middle;
        }else if(arr[middle] < middle){
            return findMagicIndex(arr, middle + 1, end);
        }else {
            return findMagicIndex(arr, start, middle - 1);
        }


    }

}
