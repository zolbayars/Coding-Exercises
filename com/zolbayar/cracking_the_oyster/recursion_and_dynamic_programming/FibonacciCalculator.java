package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.math.BigInteger;

public class FibonacciCalculator {

    // A solution with memoization (but bottom up) and recursion
    // Even faster one. When n = 300, runtime is 4ms
    public BigInteger fibonacciBottomUp(int n){
        if(n == 0) return BigInteger.ZERO;

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for(int i = 2; i < n; i++){
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }

        return a.add(b);
    }

    // A solution with memoization
    // n = 50, Runtime: 3ms
    // n = 300, Runtime: 7ms Wow!
    public BigInteger fibonacciTopDown(int n, BigInteger[] memo){
        if(n == 0) return BigInteger.ZERO;
        if(n == 1) return  BigInteger.ONE;

        if(memo[n] == null){
            memo[n] = fibonacciTopDown(n - 1, memo).add(fibonacciTopDown(n - 2, memo));
        }

        return memo[n];
    }

    // A brute force solution
    // n = 50, Runtime: 279617ms
    public BigInteger fibonacciBF(int n){
        if(n == 0) return BigInteger.ZERO;
        if(n == 1) return BigInteger.ONE;

        return fibonacciBF(n - 1).add(fibonacciBF(n - 2));
    }
}
