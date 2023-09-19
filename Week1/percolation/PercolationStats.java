/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96; // constant to calculate
    private final int trials; // the total number of trials
    private final double meanC;
    private final double stddevC;

    // using Percolation data type, fills in the element and calculate the
    // percolation threshold
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException((n) + " can't be < or == zero ");
        this.trials = trials;
        // array to store percantage of Percolations
        double[] percProb = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation pi = new Percolation(n);

            while (!pi.percolates()) {

                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);
                pi.open(row, col);
            }
            percProb[i] = pi.numberOfOpenSites() / (n * n * 1.0);
        }

        meanC = StdStats.mean(percProb);
        stddevC = StdStats.stddev(percProb);
    }

    // sample mean of percolation threshold
    public double mean() {
        return meanC;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddevC;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return meanC - (CONFIDENCE_95 * stddevC) / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return meanC + (CONFIDENCE_95 * stddevC) / Math.sqrt(trials);
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, t);

        String a = ps.confidenceLo() + ", " + ps.confidenceHi() + "]";
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = [" + a);
    }
}

