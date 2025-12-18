class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        long[] prefProfit = new long[n + 1];
        long[] prefPrice = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefProfit[i + 1] = prefProfit[i] + (long) strategy[i] * prices[i];
            prefPrice[i + 1] = prefPrice[i] + prices[i];
        }

        long[] suffProfit = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffProfit[i] = suffProfit[i + 1] + (long) strategy[i] * prices[i];
        }

        long ans = baseProfit;

     
        for (int i = 0; i + k <= n; i++) {
            long left = prefProfit[i];
            long right = suffProfit[i + k];

           
            long mid = prefPrice[i + k] - prefPrice[i + k / 2];

            ans = Math.max(ans, left + mid + right);
        }

        return ans;
    }
}
