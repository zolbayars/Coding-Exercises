import com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        long before = System.currentTimeMillis();

        RecursiveMultiply recursiveMultiply = new RecursiveMultiply();
        int result = recursiveMultiply.multiply(30, 37);

//        int result = recursiveMultiply.fibonacci(9);
//        System.out.println("(3 >> 1) = " + (3 >> 1));
        System.out.println("result = " + result);

//        Subset subset = new Subset();
//        List<Integer> set = new ArrayList<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
////        List<List<Integer>> sets = subset.getSubLists(set);
//        List<List<Integer>> sets = subset.getSubSets(set, 0);
//        for (List<Integer> innerSet : sets) {
//            for (Integer integer : innerSet) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }


//        int[] arr = new int[]{-50, -10, 1, 2, 3, 4, 5, 9, 10, 10, 10, 15, 21, 36, 100};
//        MagicIndex magicIndex = new MagicIndex();
//        int result = magicIndex.findMagicIndex(arr);

//        System.out.println("Result: " + result);

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
