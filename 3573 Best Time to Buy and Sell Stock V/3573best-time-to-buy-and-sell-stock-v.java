class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n == 0) return 0;

        long[][] dp = new long[k + 1][3];

        for (int j = 0; j <= k; j++) {
            dp[j][1] = Long.MIN_VALUE / 2;
            dp[j][2] = Long.MIN_VALUE / 2;
        }

       
        dp[0][0] = 0;

        for (int price : prices) {
            long[][] newDp = new long[k + 1][3];
            for (int j = 0; j <= k; j++) {
                newDp[j][0] = dp[j][0];
                newDp[j][1] = dp[j][1];
                newDp[j][2] = dp[j][2];
            }

            for (int j = 0; j <= k; j++) {
                newDp[j][0] = Math.max(newDp[j][0], dp[j][1] + price);
                newDp[j][0] = Math.max(newDp[j][0], dp[j][2] - price);

                if (j > 0) {
                    newDp[j][1] = Math.max(newDp[j][1], dp[j - 1][0] - price);
                    newDp[j][2] = Math.max(newDp[j][2], dp[j - 1][0] + price);
                }
            }

            dp = newDp;
        }

        return dp[k][0];
    }
}
