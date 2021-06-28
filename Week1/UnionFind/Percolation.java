

public class Percolation {

    private boolean[][] per; // grid to store block
    private final int sN; // size of edge of square grid
    private QuickUnionPathCompression qf; // making object of WeightedQuickUnionUF
    private QuickUnionPathCompression qf1; // another qf1 to prevent backwash
    private int totalOpenSites = 0; // count of number of the open sites

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        sN = n;
        if (n <= 0)
            throw new IllegalArgumentException((n) + " can't be < than or= to zero ");
        else {
            per = new boolean[n][n];
            qf = new QuickUnionPathCompression(n * n + 2);
            qf1 = new QuickUnionPathCompression(n * n + 1);

            // setting whole grid to close
            for (int i = 0; i < sN; i++) {
                for (int j = 0; j < sN; j++) {
                    per[i][j] = false;
                }
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col))
            return;
        checkIfRowColInvalid(row, col);

        per[row - 1][col - 1] = true;
        totalOpenSites++;

        int currentIndexInqf = sN * (row - 1) + col;
        if (sN == 1) {
            qf.union(0, currentIndexInqf);
            qf.union(2, currentIndexInqf);
            qf1.union(0, currentIndexInqf);
            return;
        }

        if (row != sN) {
            if (row == 1) {
                qf.union(0, currentIndexInqf);
                qf1.union(0, currentIndexInqf);
            }
            if (isOpen(row + 1, col)) {
                qf.union(currentIndexInqf, sN * (row) + col);
                qf1.union(currentIndexInqf, sN * (row) + col);
            }
        }
        if (row != 1) {
            if (row == sN) {
                qf.union(sN * sN + 1, currentIndexInqf);
            }
            if (isOpen(row - 1, col)) {
                qf.union(currentIndexInqf, sN * (row - 2) + col);
                qf1.union(currentIndexInqf, sN * (row - 2) + col);
            }
        }

        if (col == 1) {
            attemptUnion(currentIndexInqf, row, col + 1);
        }
        else if (col == sN) {
            attemptUnion(currentIndexInqf, row, col - 1);
        }
        else {
            attemptUnion(currentIndexInqf, row, col + 1);
            attemptUnion(currentIndexInqf, row, col - 1);
        }
    }

    private void attemptUnion(int currentIndexInqf, int neighbourRow, int neighbourCol) {
        if (isOpen(neighbourRow, neighbourCol)) {
            int connectingNeighbour = sN * (neighbourRow - 1) + neighbourCol;
            qf.union(currentIndexInqf, connectingNeighbour);
            qf1.union(currentIndexInqf, connectingNeighbour);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkIfRowColInvalid(row, col);
        return (per[row - 1][col - 1]);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkIfRowColInvalid(row, col);
        return qf1.root(0) == qf1.root(sN * (row - 1) + col);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return totalOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return qf.root(0) == qf.root(sN * sN + 1);
    }

    private void checkIfRowColInvalid(int row, int col) {
        if (row < 1 || row > sN || col < 1 || col > sN)
            throw new IllegalArgumentException(
                    row + ", " + col + " cant be less than zero and greater than n");
    }
}
