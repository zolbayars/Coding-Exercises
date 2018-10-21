import com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming.FibonacciCalculator;
import com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming.RobotInGrid;
import com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming.TripleSteps;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){


        long before = System.currentTimeMillis();

//        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
//        BigInteger result = fibonacciCalculator.fibonacciBottomUp(300);

//        TripleSteps tripleSteps = new TripleSteps();
//        int result = tripleSteps.countSteps(35);

        boolean[][] booleanGrid = new boolean[5][7];
        boolean[] booleanCol = new boolean[7];
        Arrays.fill(booleanCol, true);
        Arrays.fill(booleanGrid, booleanCol);

//        booleanGrid[2][2] = false;

        RobotInGrid robotInGrid = new RobotInGrid();
        ArrayList<Point> path = robotInGrid.getPath(booleanGrid);

        if(path == null){
            System.out.println("There is no path");
        }else{
            System.out.println("Here's the path:");
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i).toString());
            }
        }

//        System.out.println("Result: " + result);

        long after = System.currentTimeMillis();

        System.out.println("Run Time: " + (after - before) + "ms");
    }
}
