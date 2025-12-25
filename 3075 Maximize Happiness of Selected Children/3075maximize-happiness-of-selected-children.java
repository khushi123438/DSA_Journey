class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int n = happiness.length;
        
        
        for (int i = 0; i < k; i++) {
            ans += Math.max(0, happiness[n - 1 - i] - i);
        }
        return ans;
    }
}
