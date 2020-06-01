import java.util.Random;
import java.util.Scanner;

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
            	Random generator = new Random();
                int row = generator.nextInt(n )+1 ;
                int col = generator.nextInt(n ) +1;
                pi.open(row, col);
            }
            percProb[i] = pi.numberOfOpenSites() / (n * n * 1.0);
        }
        double sum = 0.0, standardDeviation=0.0;
        
        for(double num : percProb) {
            sum += num;
        }

        meanC =  sum/trials;
        		
        for(double num: percProb) {
            standardDeviation += Math.pow(num - meanC, 2);
        }
        
        stddevC = Math.sqrt(standardDeviation/trials);
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
    	Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        PercolationStats ps = new PercolationStats(n, t);

        String a = ps.confidenceLo() + ", " + ps.confidenceHi() + "]";
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = [" + a);
    }
}
