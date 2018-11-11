package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

/**
 *  Purpose: Write multiply function without using the * operator
 *
 *  Insight: Think about what it really means to do something, even when it's pretty obvious!
 *          What it means to do multiplication?
 *          - 7 * 9 means counting cells of a "7 by 9 grid". But how? Just counting it one by one is really inefficient.
 *          - Count half of it and then add it to itself!
 *
 */

public class RecursiveMultiply {

    int sum = 0;

    public int multiply(int a, int b){

        int smaller = a < b ? a : b;
        int bigger = a > b ? a : b;

        return multiplyHelper(smaller, bigger);
    }

    private int multiplyHelper(int smaller, int bigger){
        System.out.println("smaller = " + smaller + " bigger = " + bigger);
        if(smaller == 0){
            return 0;
        }
        if(smaller == 1){
            return bigger;
        }

        int half = smaller >> 1;
        int halfResult = multiplyHelper(half, bigger);

        System.out.println("halfResult = " + halfResult);

        if(smaller % 2 == 0){
            return halfResult + halfResult;
        }else{
            return halfResult + halfResult + bigger;
        }
    }
}
