package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

/**
 *  Purpose: Write multiply function without using the * operator
 *
 *
 */

public class RecursiveMultiply {

    int sum = 0;

    public int multiply(int a, int b){

        System.out.println("b = " + b);

        if(b == 0){
            return 0;
        }

        if(b == 1){
            return a;
        }


        sum = multiply(a, b - 1) + multiply(a, b - 2);

        return sum;
    }

    public int fibonacci(int x){

        if(x == 0){
            return 0;
        }

        if(x == 1){
            return 1;
        }



        return fibonacci(x - 1) + fibonacci( x - 2);
    }

}
