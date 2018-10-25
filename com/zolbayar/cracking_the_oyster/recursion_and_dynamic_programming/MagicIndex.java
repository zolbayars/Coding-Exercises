package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

/*
    Purpose: A magic index in an array Arr is where the Arr[i] = i. Find that index.

    Insight: The statement said it was a sorted array. You should take a hint from that.

    What if values were not distinct?
 */

public class MagicIndex {

    public int findMagicIndex(int[] arr){

        return findMagicIndex(arr, 0, arr.length - 1, "");
    }

    private int findMagicIndex(int[] arr, int start, int end, String padding){

        if(start > end){
            return -1;
        }

        int middle = (end + start) / 2;
        int midValue = arr[middle];

        System.out.println(padding + "start: " + start + " end: " + end + " mid: " + middle +
                " midValue: " + midValue);

        if(midValue == middle){
            return middle;
        }

        int leftIndex = Math.max(middle - 1, midValue);
        int left = findMagicIndex(arr, start, leftIndex, padding + "   ");
        if(left >= 0){
            return left;
        }

        int rightIndex = Math.max(middle + 1, midValue);
        return findMagicIndex(arr, rightIndex, end, padding + "   ");

    }

}
