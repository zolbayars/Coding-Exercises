package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

/*
    Purpose: A classic problem. There are 3 towers and N number of disks ordered by their sizes.
        Move the first tower to the 3rd tower using stacks
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
        while(!this.tower1.empty()){
            this.tower2.push(this.tower1.pop());
        }
        while(!this.tower2.empty()){
            this.tower3.push(this.tower2.pop());
        }

        System.out.println("tower3 = " + tower3.peek());
    }
}
