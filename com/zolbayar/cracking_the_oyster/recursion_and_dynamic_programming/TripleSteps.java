package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

/*
    Purpose: There are n steps. A child can hop on those in 1 step, 2 steps or 3 steps.
            Find how many possible ways the child can run up the stairs.
 */
public class TripleSteps {

    private final int[] stepOptions = {1, 2 ,3};

    public int countStepsBF(int n){

        if(n <= 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

        int result = 0;
        for(int i = 0; i < stepOptions.length; i++){
            result += countStepsBF(n - stepOptions[i]);
        }

        return result;
    }
}
