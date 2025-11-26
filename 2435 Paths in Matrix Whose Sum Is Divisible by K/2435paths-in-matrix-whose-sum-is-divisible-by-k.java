class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

       
        int[][] dp = new int[n][k];
        int[][] newDp = new int[n][k];

        for (int i = 0; i < m; i++) {
          
            for (int j = 0; j < n; j++) {
                for (int r = 0; r < k; r++) {
                    newDp[j][r] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                for (int r = 0; r < k; r++) {
                    if (i == 0 && j == 0) {
                        int rem = grid[0][0] % k;
                        newDp[0][rem] = 1;
                        break;
                    }

                    int val = grid[i][j];

                    if (i > 0) {
                        int newR = (r + val) % k;
                        newDp[j][newR] = (newDp[j][newR] + dp[j][r]) % MOD;
                    }

        
                    if (j > 0) {
                        int newR = (r + val) % k;
                        newDp[j][newR] = (newDp[j][newR] + newDp[j-1][r]) % MOD;
                    }
                }
            }

   
            for (int j = 0; j < n; j++) {
                System.arraycopy(newDp[j], 0, dp[j], 0, k);
            }
        }

        return dp[n - 1][0];
    }
}