package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

/*
    Purpose: A classic problem. There are 3 towers and N number of disks ordered by their sizes.
        Move the first tower to the 3rd tower using stacks

    Insight: A disk cannot be placed on a smaller disk! Read the description carefully!
            Base case and Build!
 */

import java.util.Stack;

public class TowersOfHanoi {

    private Stack<Integer> tower1;
    private Stack<Integer> tower2;
    private Stack<Integer> tower3;

    public TowersOfHanoi() {
        this.tower1 = new Stack<>();
        this.tower1.push(100);
        this.tower1.push(76);
        this.tower1.push(55);
        this.tower1.push(34);
        this.tower1.push(10);
        this.tower1.push(2);

        this.tower2 = new Stack<>();
        this.tower3 = new Stack<>();
    }

    public void move(){
        Stack<Integer> result = move(this.tower1, this.tower2, this.tower3);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    // 2 10 34 55
    public Stack<Integer> move(Stack<Integer> tower1, Stack<Integer> tower2, Stack<Integer> tower3){

        if(tower2.size() == 1){
            tower3.push(tower2.pop());
            return tower3;
        }

        if(tower2.size() == 2){
            tower1.push(tower2.pop());
            tower3.push(tower2.pop());
            tower3.push(tower1.pop());
            return tower3;
        }

        tower2.push(tower1.pop());
        return move(tower1, tower2, tower3);
    }
}
