import com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming.FibonacciCalculator;
import com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming.MagicIndex;
import com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming.RobotInGrid;
import com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming.TripleSteps;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){


        long before = System.currentTimeMillis();

        int[] arr = new int[]{5, 2, 1, 10};
        MagicIndex magicIndex = new MagicIndex();
        int result = magicIndex.findMagicIndex(arr);

        System.out.println("Result: " + result);

//        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
//        BigInteger result = fibonacciCalculator.fibonacciBottomUp(300);

//        TripleSteps tripleSteps = new TripleSteps();
//        int result = tripleSteps.countSteps(35);

//        boolean[][] booleanGrid = new boolean[5][5];
//        boolean[] booleanCol = new boolean[5];
//        Arrays.fill(booleanCol, true);
//        Arrays.fill(booleanGrid, booleanCol);

//        booleanGrid[2][2] = false;

//        for (int i = 0; i < booleanGrid.length ; i++) {
//            for (int j = 0; j < booleanGrid[i].length; j++) {
//                if(i == 2 && j == 2){
//                    booleanGrid[i][j] = false;
//                    break;
//                }
//                System.out.println(i + " - " + j + ":" + booleanGrid[i][j]);
//            }
//        }


//        System.out.println(booleanGrid[0][0]);
//        System.out.println(booleanGrid[0][1]);
//        System.out.println(booleanGrid[0][2]);
//        System.out.println(booleanGrid[0][3]);
//        System.out.println(booleanGrid[0][4]);
//        System.out.println(booleanGrid[2][0]);
//        System.out.println(booleanGrid[2][1]);
//        System.out.println(booleanGrid[2][2]);

//        RobotInGrid robotInGrid = new RobotInGrid();
//        ArrayList<Point> path = robotInGrid.getPath(booleanGrid);
//
//        if(path == null){
//            System.out.println("There is no path");
//        }else{
//            System.out.println("Here's the path:");
//            for (int i = 0; i < path.size(); i++) {
//                System.out.println(path.get(i).toString());
//            }
//        }

//        System.out.println("Result: " + result);

        long after = System.currentTimeMillis();

        System.out.println("Run Time: " + (after - before) + "ms");
    }
}
