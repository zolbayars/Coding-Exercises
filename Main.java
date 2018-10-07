import com.zolbayar.cracking_the_oyster.recursion_and_dynamic_programming.FibonacciCalculator;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args){


        long before = System.currentTimeMillis();

        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        BigInteger result = fibonacciCalculator.fibonacciBottomUp(300);

        System.out.println("Result: " + result);

        long after = System.currentTimeMillis();

        System.out.println("Run Time: " + (after - before) + "ms");
    }
}
