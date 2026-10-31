class Solution {
    static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Integer[][][] dp = new Integer[m][n][2];

        return solve(0, 0, 0, grid, dp);
    }

    // dir = 0: entered moving right
    // dir = 1: entered moving down
    private int solve(int i, int j, int dir,
                      int[][] grid, Integer[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j][dir] != null) {
            return dp[i][j][dir];
        }

        long ans = 0;

        if (grid[i][j] == 1) {
            if (dir == 0) {
                ans = solve(i + 1, j, 1, grid, dp);
            } else {
                ans = solve(i, j + 1, 0, grid, dp);
            }
        } else {
            ans = solve(i + 1, j, 1, grid, dp)
                + solve(i, j + 1, 0, grid, dp);
        }

        return dp[i][j][dir] = (int) (ans % MOD);
    }
}