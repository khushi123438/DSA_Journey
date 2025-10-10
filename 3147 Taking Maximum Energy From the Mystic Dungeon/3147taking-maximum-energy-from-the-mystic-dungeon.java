class Solution {
    public int maximumEnergy(int[] energy, int k) {
         int n = energy.length;
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[n];

        
        for (int r = 0; r < k; r++) {
            
            for (int i = n - 1 - ((n - 1 - r) % k); i >= r; i -= k) {
                if (i + k < n) {
                    dp[i] = energy[i] + dp[i + k];
                } else {
                    dp[i] = energy[i];
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
    
}