class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 0;
        int n = prices.length;
        
      
        long currentLen = 1;
        
        total += currentLen;
        
        for (int i = 1; i < n; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            total += currentLen;
        }
        
        return total;
    }
}
