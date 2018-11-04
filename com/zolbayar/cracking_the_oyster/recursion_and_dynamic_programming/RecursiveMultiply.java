package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

/**
 *  Purpose: Write multiply function without using the * operator
 *
 *
 */

public class RecursiveMultiply {

    public int multiply(int a, int b){

        int result = 0;

        for (int i = 0; i < b; i++) {
            result += a;
        }

        return result;
    }

}
