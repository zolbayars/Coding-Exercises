package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;
/*
    Purpose: A robot can only move in right and down direction in a grid with c columns and r rows.
            Some cells are off-limit for that robot

    My Solution: grid should be 2d array with 0s filled in. The off limit cells are filled with -1s.
                 The cells where robot moved should be filled with 1.
 */
public class RobotInGrid {

    private int[][] grid;
    private int counter = 0;

    public RobotInGrid(){
        this.grid = new int[5][7];
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = 0;
            }
        }

        // Starting point for the robot
        this.grid[0][0] = 1;


    }

    public RobotInGrid(int[][] grid){
        this.grid = grid;
    }

    public void moveRobotFromTop(){
        moveToRightMostBottom(this.grid, 0, 0);
    }

    private boolean moveToRightMostBottom(int[][] grid, int colStart, int rowStart){
        counter++;

        if(colStart >= grid.length){
            return false;
        }

        if(rowStart >= grid[colStart].length){
            return false;
        }

        if(colStart == (grid.length - 1) && rowStart == (grid[colStart].length - 1)){
            System.out.println("Robot reached its destination after " + counter + " recursion");
            return true;
        }else{
            System.out.println("colStart: " + colStart);
            System.out.println("rowStart: " + rowStart);
        }

        if(grid[colStart][rowStart] == -1 || grid[colStart][rowStart] == 1){
            return moveToRightMostBottom(grid, colStart + 1, rowStart) ||
                    moveToRightMostBottom(grid, colStart, rowStart + 1) ||
                    moveToRightMostBottom(grid, colStart + 1, rowStart + 1);
        }else {
            grid[colStart][rowStart] = 1;
            return moveToRightMostBottom(grid, colStart, rowStart);
        }

    }
}
