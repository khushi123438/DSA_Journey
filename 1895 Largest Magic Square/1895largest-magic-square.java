class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m + 1][n + 1];
        int[][] col = new int[m + 1][n + 1];

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i + 1][j + 1] = row[i + 1][j] + grid[i][j];
                col[i + 1][j + 1] = col[i][j + 1] + grid[i][j];
            }
        }

        int maxSize = Math.min(m, n);

        for (int size = maxSize; size >= 2; size--) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int target = row[i + 1][j + size] - row[i + 1][j];

                    boolean ok = true;

                   
                    for (int r = i; r < i + size; r++) {
                        if (row[r + 1][j + size] - row[r + 1][j] != target) {
                            ok = false;
                            break;
                        }
                    }

                  
                    for (int c = j; c < j + size && ok; c++) {
                        if (col[i + size][c + 1] - col[i][c + 1] != target) {
                            ok = false;
                            break;
                        }
                    }

                    int d1 = 0, d2 = 0;
                    for (int k = 0; k < size && ok; k++) {
                        d1 += grid[i + k][j + k];
                        d2 += grid[i + k][j + size - 1 - k];
                    }

                    if (ok && d1 == target && d2 == target) {
                        return size;
                    }
                }
            }
        }
        return 1;
    }
}
