package assign05;

import java.util.ArrayList;

/**
 * 
 * This program tries to determine how long it takes to compute the square root
 * 
 * of each number from 1 through 10.
 * 
 * @author Erin Parker
 * 
 * @version January 21, 2022
 * 
 */

public class SorterTiming {

    public static void main(String[] args) {

        long startTime, midpointTime, stopTime;

        // First, spin computing stuff until one second has gone by.

        // This allows this thread to stabilize.

        startTime = System.nanoTime();

        while (System.nanoTime() - startTime < 1000000000) { // empty block

        }

        // Now, run the test.

        long timesToLoop = 1000;

        startTime = System.nanoTime();
        int q;
        for (q = 1000; q <= 10000; q += 500) {

            for (long i = 0; i < timesToLoop; i++) {

                ArrayList<Integer> temp = ArrayListSorter.generatePermuted(q);

                ArrayListSorter.quicksort(temp);

            }

            midpointTime = System.nanoTime();

            // Run an empty loop to capture the cost of running the loop.

            for (long i = 0; i < timesToLoop; i++) {
                @SuppressWarnings("unused")
                ArrayList<Integer> temp = ArrayListSorter.generatePermuted(q);
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop

            // from the cost of running the loop and computing square roots.

            // Average it over the number of runs.

            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

            System.out.print(averageTime + " " + q + "\n");
        }
    }
}
