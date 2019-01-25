package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.util.ArrayList;

public class Paren {

    // 1 -> ()
    // 2 -> ()() (())
    // 3 -> ()()() ((())) (()()) (())() ()(())
    // 4 -> ()()()() (((()))) (())(()) ()()(()) ()(())() (())()() ((()))() ()((()))
    public void printAllPerms(int num){

    }

    ArrayList<String> getPerms(int count, ArrayList<String> result){
        if(count == 1){
            result.add("()");
            return result;
        }

        return null;
    }
}
