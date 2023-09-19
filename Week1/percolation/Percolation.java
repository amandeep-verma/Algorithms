/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private int totalOpenSites = 0;
    private WeightedQuickUnionUF qf;
    private WeightedQuickUnionUF qf1;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("can't be < than or= to zero");
        grid = new boolean[n][n];
        qf = new WeightedQuickUnionUF(n * n + 2);
        qf1 = new WeightedQuickUnionUF(n * n + 1);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        ifIndexValid(row, col);
        if (isOpen(row, col))
            return;

        grid[row - 1][col - 1] = true;
        totalOpenSites++;

        int currentIndex = grid.length * (row - 1) + col;

        if (grid.length == 1) {
            qf.union(0, currentIndex);
            qf.union(2, currentIndex);
            qf1.union(0, currentIndex);
            return;
        }

        if (row != 1) {
            attemptUnion(currentIndex, row - 1, col);
            if (row == grid.length)
                qf.union(grid.length * grid.length + 1, currentIndex);
        }
        if (row != grid.length) {
            attemptUnion(currentIndex, row + 1, col);
            if (row == 1) {
                qf.union(0, currentIndex);
                qf1.union(0, currentIndex);
            }
        }

        if (col != 1) {
            attemptUnion(currentIndex, row, col - 1);
        }
        if (col != grid.length) {
            attemptUnion(currentIndex, row, col + 1);
        }
    }

    private void attemptUnion(int currentIndex, int row, int col) {
        if (isOpen(row, col)) {
            qf.union(currentIndex, grid.length * (row - 1) + col);
            qf1.union(currentIndex, grid.length * (row - 1) + col);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        ifIndexValid(row, col);
        return grid[row - 1][col - 1];
    }


    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        ifIndexValid(row, col);
        return qf1.find(0) == qf1.find(grid.length * (row - 1) + col);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return totalOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return qf.find(0) == qf.find(grid.length * grid.length + 1);
    }

    private void ifIndexValid(int row, int col) {
        if (row < 1 || col < 1 || row > grid[0].length || col > grid[0].length)
            throw new IllegalArgumentException("index invalid");
    }
}
