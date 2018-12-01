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
        System.out.println("Before:");
        System.out.println("this.tower1 = " + this.tower1);
        System.out.println("this.tower2 = " + this.tower2);
        System.out.println("this.tower3 = " + this.tower3);

        ThreeTowers result = move(this.tower1, this.tower2, this.tower3, this.tower1.size());

        System.out.println("After:");
        System.out.println("this.tower1 = " + this.tower1);
        System.out.println("this.tower2 = " + this.tower2);
        System.out.println("this.tower3 = " + this.tower3);
    }

    // 2 10 34 55
    public ThreeTowers move(Stack<Integer> tower1, Stack<Integer> tower2, Stack<Integer> tower3, int sizeToMove){

        if(sizeToMove == 1){
            tower3.push(tower1.pop());
            return new ThreeTowers(tower1, tower2, tower3);
        }

        if(sizeToMove == 2){
            tower2.push(tower1.pop());
            tower3.push(tower1.pop());
            tower3.push(tower2.pop());
            return new ThreeTowers(tower1, tower2, tower3);
        }

        ThreeTowers towersAfterMove = move(tower1, tower2, tower3, sizeToMove - 1);
        System.out.println("towersAfterMove = " + towersAfterMove + " sizeToMove = " + sizeToMove);
        Stack<Integer> tower1Modified = towersAfterMove.getTower1();
        Stack<Integer> tower2Modified = towersAfterMove.getTower2();
        Stack<Integer> tower3Modified = towersAfterMove.getTower3();
        tower2Modified.push(tower1Modified.pop());

        return move(tower3Modified, tower1Modified, tower2Modified, sizeToMove - 1);
//        return new ThreeTowers(tower1Modified, tower2Modified, tower3Modified);
    }

    class ThreeTowers {
        private Stack<Integer> tower1;
        private Stack<Integer> tower2;
        private Stack<Integer> tower3;

        public ThreeTowers(Stack<Integer> tower1, Stack<Integer> tower2, Stack<Integer> tower3) {
            this.tower1 = tower1;
            this.tower2 = tower2;
            this.tower3 = tower3;
        }

        public Stack<Integer> getTower1() {
            return tower1;
        }

        public Stack<Integer> getTower2() {
            return tower2;
        }

        public Stack<Integer> getTower3() {
            return tower3;
        }

        @Override
        public String toString() {
            return "ThreeTowers{" +
                    "tower1=" + tower1 +
                    ", tower2=" + tower2 +
                    ", tower3=" + tower3 +
                    '}';
        }
    }
}
