import java.util.*;

class Solution {
    private static final int MOD = (int)1e9 + 7;

    // Fast modular exponentiation
    private long quickMul(long a, long b, long mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;

        // Factorials
        long[] fac = new long[m + 1];
        fac[0] = 1;
        for (int i = 1; i <= m; i++) fac[i] = fac[i - 1] * i % MOD;

        // Inverse factorials using Fermat's little theorem
        long[] ifac = new long[m + 1];
        ifac[0] = 1;
        for (int i = 1; i <= m; i++) ifac[i] = quickMul(i, MOD - 2, MOD);
        for (int i = 1; i <= m; i++) ifac[i] = ifac[i - 1] * ifac[i] % MOD;

        // Precompute powers of nums
        long[][] numsPower = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            numsPower[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                numsPower[i][j] = numsPower[i][j - 1] * nums[i] % MOD;
            }
        }

        // 4D DP array: f[i][j][p][q]
        long[][][][] f = new long[n][m + 1][m * 2 + 1][k + 1];

        for (int j = 0; j <= m; j++) {
            f[0][j][j][0] = numsPower[0][j] * ifac[j] % MOD;
        }

        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int p = 0; p <= m * 2; p++) {
                    for (int q = 0; q <= k; q++) {
                        int q2 = (p % 2) + q;
                        if (q2 > k) continue;
                        for (int r = 0; r + j <= m; r++) {
                            int p2 = p / 2 + r;
                            f[i + 1][j + r][p2][q2] += f[i][j][p][q] * numsPower[i + 1][r] % MOD * ifac[r] % MOD;
                            f[i + 1][j + r][p2][q2] %= MOD;
                        }
                    }
                }
            }
        }

        long res = 0;
        for (int p = 0; p <= m * 2; p++) {
            for (int q = 0; q <= k; q++) {
                if (Integer.bitCount(p) + q == k) {
                    res = (res + f[n - 1][m][p][q] * fac[m] % MOD) % MOD;
                }
            }
        }

        return (int)res;
    }

    // Test example
   
}
