package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Purpose: There are n steps. A child can hop on those in 1 step, 2 steps or 3 steps.
            Find how many possible ways the child can run up the stairs.

    Insights: - Approach top-down. What's the last step child make? ~ The step where n becomes 0?
                    The last step the child will make is n - 1 or n - 2 or n -3.
              - Just caching the value of n was enough.
 */
public class TripleSteps {

    private final int[] stepOptions = {1, 2 ,3};
    private Map<String, Integer> cache = new HashMap<>();
    private String currentKey = "";
    private int currentValue = 0;

    // n: 35, Result: 1132436852, runtime: 1ms
    public int countSteps(int n){
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countSteps(n, memo);
    }

    public int countSteps(int n, int[] memo){

        if(n == 0) return 1;
        if(n < 0) return 0;
        if(n == 1) return 1;

        if(memo[n] > -1) return memo[n];

        memo[n] = countSteps(n - 1, memo) + countSteps(n - 2, memo) +
                countSteps(n - 3, memo);

        return memo[n];
    }

    // n: 35, Result: 1132436852, runtime: 5806ms
    public int countStepsBF(int n){

        if(n == 0) return 1;
        if(n < 0) return 0;
        if(n == 1) return 1;

        System.out.println(n);

        int result = 0;

        for(int i = 0; i < stepOptions.length; i++){
            result += countStepsBF(n - stepOptions[i]);
        }

        return result;
    }
}
