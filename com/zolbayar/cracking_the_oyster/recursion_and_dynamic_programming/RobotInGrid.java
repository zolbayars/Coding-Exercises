package com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

/*
    Purpose: A robot can only move in right and down direction in a grid with c columns and r rows.
            Some cells are off-limit for that robot

    My Solution: grid should be 2d array with 0s filled in. The off limit cells are filled with -1s.
                 The cells where robot moved should be filled with 1.

    Insights: - Really try to understand the problem statement! (The robot is not able to move
                down AND right in a same move)
              - Check if there is a path
              - The base intuition was right.
              - If the value is a flag, use boolean
              - Always think about it from the end! What's the second last spot look like? etc.
 */
public class RobotInGrid {

    private int[][] grid;
    private int counter = 0;


    public RobotInGrid(){
        // Not used
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

    public ArrayList<Point> getPath(boolean[][] gridBool){
        ArrayList<Point> path = new ArrayList<>();

        HashSet<Point> failedPoints = new HashSet<>();

        if(getPath(gridBool, gridBool.length - 1, gridBool[0].length - 1, path, failedPoints)){
            return path;
        }

        return null;
    }

    private boolean getPath(boolean[][] grid, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){

//        System.out.println(space + row + " - " + col);

//        if(row >= 0 && col >= 0){
//            System.out.println(space + "" + grid[row][col]);
//        }

        // Check if it's out of range
        if(row < 0 || col < 0 || !grid[row][col]){
            return false;
        }

        Point p = new Point(row, col);

        if(failedPoints.contains(p)){
            return false;
        }

        boolean isOriginalPoint = (row == 0) && (col == 0);

        if(isOriginalPoint || getPath(grid, row - 1, col, path, failedPoints) ||
                getPath(grid, row, col - 1, path, failedPoints)){
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }

    // My way - Not correct
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
